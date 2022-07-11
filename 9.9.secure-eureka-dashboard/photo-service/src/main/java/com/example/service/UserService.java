package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email);
	UserDto getUserByUserId(String userId);
}
