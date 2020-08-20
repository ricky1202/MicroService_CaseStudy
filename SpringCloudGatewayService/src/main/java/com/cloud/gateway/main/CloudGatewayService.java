package com.cloud.gateway.main;

import org.springframework.context.annotation.Bean;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;

@Configuration
public class CloudGatewayService {

	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
	   return ServerCodecConfigurer.create();
	}
	
	 @Bean
	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
	        return builder.routes()
	                .route(r -> r.path("/user/**")
	                        .uri("lb://USER-SERVICE")
	                        .id("userModule"))
	                .route(r -> r.path("/book/**")
	                        .uri("lb://BOOK-SERVICE")
	                        .id("bookModule"))
	                .route(r -> r.path("/subscription/**")
	                        .uri("lb://SUBSCRIPTION-SERVICE")
	                        .id("subscriptionModule"))
	                .build();
	    }
}
