package com.book.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "Book.Controller")
@EnableEurekaClient
public class SprintBootBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootBookServiceApplication.class, args);
	}

}
