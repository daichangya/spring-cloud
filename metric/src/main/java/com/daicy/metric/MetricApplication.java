package com.daicy.metric;

import com.codahale.metrics.ConsoleReporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableConfigurationProperties
public class MetricApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MetricApplication.class, args);
//		ConsoleReporter.enable(10, TimeUnit.SECONDS);
		// 启动Reporter
		ConsoleReporter reporter = ctx.getBean(ConsoleReporter.class);
		reporter.start(10, TimeUnit.SECONDS);

//		ScheduledReporter influxdbReporter = ctx.getBean("influxdbReporter",ScheduledReporter.class);
//		influxdbReporter.start(1, TimeUnit.MINUTES);
	}

}
