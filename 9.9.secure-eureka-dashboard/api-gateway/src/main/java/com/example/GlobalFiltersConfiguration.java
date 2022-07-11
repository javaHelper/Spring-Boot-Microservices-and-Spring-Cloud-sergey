package com.example;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Configuration
@Slf4j
public class GlobalFiltersConfiguration {

	@Order(1)
	@Bean
	public GlobalFilter secondPreFilter() {
		return (exchange, chain) -> {
			log.info("My second global Pre-Filter is executed ...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("My 3rd global Pre-Filter was executed ...");
			}));
		};
	}
	
	@Order(2)
	@Bean
	public GlobalFilter thirdPreFilter() {
		return (exchange, chain) -> {
			log.info("My third global Pre-Filter is executed ...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("My 2nd global Pre-Filter was executed ...");
			}));
		};
	}
	
	
	@Order(3)
	@Bean
	public GlobalFilter fourthPreFilter() {
		return (exchange, chain) -> {
			log.info("My Fourth global Pre-Filter is executed ...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("My 1st global Pre-Filter was executed ...");
			}));
		};
	}
}
