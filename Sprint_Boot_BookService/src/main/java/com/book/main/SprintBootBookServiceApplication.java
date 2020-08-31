package com.book.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import Book.Controller.BookRepository;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "Book.Controller")
@EnableEurekaClient
@EnableMongoRepositories(basePackageClasses = BookRepository.class)
public class SprintBootBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootBookServiceApplication.class, args);
	}

}
