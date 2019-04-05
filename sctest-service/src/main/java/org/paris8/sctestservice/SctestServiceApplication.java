package org.paris8.sctestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SctestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SctestServiceApplication.class, args);
	}

}
