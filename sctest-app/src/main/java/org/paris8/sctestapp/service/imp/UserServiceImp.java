package org.paris8.sctestapp.service.imp;

import org.paris8.sctestapp.mapper.UserMapper;
import org.paris8.sctestapp.model.User;
import org.paris8.sctestapp.service.UserService;
import org.paris8.sctestapp.tool.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    public static final String UPDATE_REDIS_QUEUE = "update-user-redis";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void add(User user) {
        userMapper.add(user);

        rabbitMQSender.send(UPDATE_REDIS_QUEUE, "{\"event_type\": \"add\", \"data_type\": \"user\", \"id\": " + user.getId() + "}");
    }

    @Override
    public void update(User user) {
        userMapper.update(user);

        rabbitMQSender.send(UPDATE_REDIS_QUEUE, "{\"event_type\": \"update\", \"data_type\": \"user\", \"id\": " + user.getId() + "}");
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);

        rabbitMQSender.send(UPDATE_REDIS_QUEUE, "{\"event_type\": \"delete\", \"data_type\": \"user\", \"id\": " + id + "}");
    }

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
