package com.demomicroservice.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	/**Micro Service - Communication Rest-Template*/
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	/** Micro Service - Communication Web-Client */
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	/** Micro Service - Communication Feign Client */

}
