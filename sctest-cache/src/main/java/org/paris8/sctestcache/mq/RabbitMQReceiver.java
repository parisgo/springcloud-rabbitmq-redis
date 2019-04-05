package org.paris8.sctestcache.mq;

import com.google.common.base.Strings;
import net.sf.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import org.paris8.sctestcache.service.UserService;

@Component
@RabbitListener(queues = "update-user-redis")
public class RabbitMQReceiver {
    @Autowired
    private UserService userService;

    @Autowired
    private JedisPool jedisPool;

    @RabbitHandler
    public void process(String message) {
        JSONObject jsonObject = JSONObject.fromObject(message);

        String dataType = jsonObject.getString("data_type");
        if("user".equals(dataType)) {
            userDataChangeMessage(jsonObject);
        }
    }

    private void userDataChangeMessage(JSONObject messageJSONObject) {
        Long id = messageJSONObject.getLong("id");
        String eventType = messageJSONObject.getString("event_type");

        if("add".equals(eventType) || "update".equals(eventType)) {
            String ret = userService.getById(id);
            if(!Strings.isNullOrEmpty(ret)) {
                JSONObject dataJSONObject = JSONObject.fromObject(ret);
                Jedis jedis = jedisPool.getResource();
                jedis.set("user_" + dataJSONObject.getLong("id"), dataJSONObject.toString());
            }
        } else if ("delete".equals(eventType)) {
            Jedis jedis = jedisPool.getResource();
            jedis.del("user_" + id);
        }
    }
}
