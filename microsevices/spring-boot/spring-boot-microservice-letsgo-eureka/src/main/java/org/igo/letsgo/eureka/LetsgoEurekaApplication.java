package org.igo.letsgo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LetsgoEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsgoEurekaApplication.class, args);
	}
}
