package com.daicy.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@ImportResource("classpath*:spring/*.xml")
//@EnableCaching
public class SleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
