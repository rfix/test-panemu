package com.api2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Api2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Api2ServiceApplication.class, args);
	}

}
