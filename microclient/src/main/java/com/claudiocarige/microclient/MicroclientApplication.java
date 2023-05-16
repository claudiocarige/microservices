package com.claudiocarige.microclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroclientApplication.class, args);
	}

}
