package com.appsdevloperblog.photoapp.api.users.service;

import java.util.ArrayList;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.appsdevloperblog.photoapp.api.users.data.UserEntity;
import com.appsdevloperblog.photoapp.api.users.data.UsersRepository;
import com.appsdevloperblog.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService{

	
	UsersRepository usersRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository,BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		this.usersRepository=usersRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	
	
	@Override
	public UserDto createUser(UserDto userDeatils) {
		userDeatils.setUserId(UUID.randomUUID().toString());
		userDeatils.setEncryptedPassword(bCryptPasswordEncoder.encode(userDeatils.getPassword()));
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=modelMapper.map(userDeatils, UserEntity.class);
		
		usersRepository.save(userEntity);
		UserDto returnValue=modelMapper.map(userEntity, UserDto.class);
		
    	return returnValue;

    }
	@Override
	public UserDto getUserDetailsByEmail(String email) {
		UserEntity userEntity=usersRepository.findByEmail(email);
		if(userEntity==null) throw new UsernameNotFoundException(email);
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=usersRepository.findByEmail(username);
		
		if(userEntity==null) throw new UsernameNotFoundException(username);
		
		
     	return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}

	
}

