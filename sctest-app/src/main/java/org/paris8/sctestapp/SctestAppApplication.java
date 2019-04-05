package org.paris8.sctestapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.paris8.sctestapp.service.UserService;

@SpringBootApplication
@EnableEurekaClient
public class SctestAppApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SctestAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("user id: 1 -> {}", userService.getById(1L));
	}
}
