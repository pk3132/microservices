package com.appsdevloperblog.photoapp.api.users.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

import com.appsdevloperblog.photoapp.api.users.service.UsersService;
import com.appsdevloperblog.photoapp.api.users.shared.UserDto;
import com.appsdevloperblog.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.appsdevloperblog.photoapp.api.users.ui.model.CreateUserResponseModel;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersService usersService;

	@Autowired
	private Environment envirement;

	@GetMapping("/status/check")
	public String status() {
		return "Users working fine with port " + envirement.getProperty("local.server.port");
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDeatils) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDeatils, UserDto.class);
		UserDto createUser = usersService.createUser(userDto);
		CreateUserResponseModel returnValue = modelMapper.map(createUser, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
		

	}

}
