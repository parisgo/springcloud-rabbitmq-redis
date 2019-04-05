package org.paris8.sctestcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SctestCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SctestCacheApplication.class, args);
	}

	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000 * 10);
		config.setTestOnBorrow(true);
		return new JedisPool(config, "localhost", 6379);
	}
}
