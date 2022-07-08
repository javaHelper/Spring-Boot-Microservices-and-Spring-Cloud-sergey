package com.example.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.dto.UserDto;
import com.example.model.LoginRequestModel;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private UserService userService;
	private Environment env;
	
	public AuthenticationFilter(UserService userService, Environment env, AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.env = env;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			LoginRequestModel cred = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					cred.getEmail(), cred.getPassword(), new ArrayList<>());

			return getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String userName = ((User) authResult.getPrincipal()).getUsername();
		UserDto userDto = userService.getUserDetailsByEmail(userName);
		
		long expiryTime = Long.parseLong(env.getProperty("token.expiration_time"));
		
		String token = Jwts.builder()
			.setSubject(userDto.getUserId())
			.setExpiration(new Date(System.currentTimeMillis()+ expiryTime))
			.signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
			.compact();
		
		response.addHeader("token", token);
        response.addHeader("userId", userDto.getUserId());
	}
}
