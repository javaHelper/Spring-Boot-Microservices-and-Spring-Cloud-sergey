package com.example;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyPreFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("--- My first Pre-filter is executed ....");

		String requestPath = exchange.getRequest().getPath().toString();
		log.info("--- Request Path = " + requestPath);

		HttpHeaders httpHeaders = exchange.getRequest().getHeaders();

		Set<String> headerNames = httpHeaders.keySet();

		headerNames.forEach(headerName -> {
			String headerValue = httpHeaders.getFirst(headerName);
			log.info(headerName + " <=> " + headerValue);
		});

		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
