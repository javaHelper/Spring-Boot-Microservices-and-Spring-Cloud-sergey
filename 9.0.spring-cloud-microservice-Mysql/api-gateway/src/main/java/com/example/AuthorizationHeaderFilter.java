package com.example;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;


@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

	@Autowired
	private Environment env;

	public AuthorizationHeaderFilter() {
		super(Config.class);
	}

	public static class Config{
		// Put configuration properties here!
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {

			ServerHttpRequest httpRequest = exchange.getRequest();

			if(!httpRequest.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				return onError(exchange, "No Authorization Header", HttpStatus.UNAUTHORIZED);
			}

			String authorizationHeader = httpRequest.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

			String jwt = authorizationHeader.replace("Bearer", "");

			if(!isJwtValid(jwt)) {
				return onError(exchange, "JWT Token is not valid!", HttpStatus.UNAUTHORIZED);
			}

			return chain.filter(exchange);
		};
	}


	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus){
		ServerHttpResponse httpResponse = exchange.getResponse();
		httpResponse.setStatusCode(httpStatus);
		return httpResponse.setComplete();
	}

	private boolean isJwtValid(String jwt) {
		boolean returnValue = true;
		String subject = null;
		try {
			subject = Jwts.parser()
					.setSigningKey(env.getProperty("token.secret"))
					.parseClaimsJws(jwt)
					.getBody()
					.getSubject();
		} catch (Exception e) {
			returnValue = false;
		}

		if(subject == null || subject.isEmpty()) {
			returnValue = false;
		}
		return returnValue;
	}

}
