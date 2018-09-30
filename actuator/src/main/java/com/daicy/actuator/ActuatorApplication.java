package com.daicy.actuator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
//@ImportResource("classpath*:spring/*.xml")
//@EnableCaching
public class ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
	}

}
