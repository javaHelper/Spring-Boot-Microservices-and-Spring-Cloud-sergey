package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.model.CreateUserRequestModel;
import com.example.model.CreateUserResponseModel;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("status/check")
	public String status() {
		return "Working on port " + env.getProperty("local.server.port") + ", with token = " + env.getProperty("token.secret");
	}
	
	
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userRequestModel) {
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		UserDto createUser = userService.createUser(userDto);
		
		CreateUserResponseModel responseModel = modelMapper.map(createUser, CreateUserResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}
}
