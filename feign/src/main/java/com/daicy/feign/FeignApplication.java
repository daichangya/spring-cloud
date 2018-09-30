package com.daicy.feign;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.httpclient.HttpClientMetricNameStrategies;
import com.codahale.metrics.httpclient.InstrumentedHttpRequestExecutor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class FeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public HttpClient httpClient(@Value("${feign.http-client.max-conn-per-route:5}") int maxConnPerRoute,
								 @Value("${feign.http-client.max-conn-total:500}") int maxConnTotal,MetricRegistry metricRegistry) {
		HttpClient httpClient = HttpClientBuilder.create()
				.setRequestExecutor(new InstrumentedHttpRequestExecutor(metricRegistry, HttpClientMetricNameStrategies.QUERYLESS_URL_AND_METHOD))
				.setMaxConnTotal(maxConnTotal).setMaxConnPerRoute(maxConnPerRoute).build();
		return httpClient;
	}
}
