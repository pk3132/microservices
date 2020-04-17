package com.appsdevloperblog.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdevloperblog.photoapp.api.users.shared.UserDto;
import com.appsdevloperblog.photoapp.api.users.ui.model.CreateUserRequestModel;

public interface UsersService extends UserDetailsService {

	UserDto createUser(UserDto userDeatil);
	UserDto getUserDetailsByEmail(String email);
	

}
