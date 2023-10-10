package com.api3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Api3ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Api3ServiceApplication.class, args);
	}

}
