package org.igo.letsgo.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class LetsgoHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsgoHystrixApplication.class, args);
	}
}
