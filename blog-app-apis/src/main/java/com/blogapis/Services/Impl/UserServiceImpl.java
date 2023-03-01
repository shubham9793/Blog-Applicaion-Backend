package com.blogapis.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.blogapis.Config.AppConstants;
import com.blogapis.Entities.Role;
import com.blogapis.Repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapis.Entities.User;
import com.blogapis.Payloads.UserDto;
import com.blogapis.Repositories.UserRepository;
import com.blogapis.Services.UserService;
import com.blogapis.Exceptions.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	// Register New User
	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto,User.class);
		// set Encoded password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		//  get Role
		Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();

		user.getRoles().add(role);

		User newUser = this.userRepository.save(user);
		return this.modelMapper.map(newUser,UserDto.class);
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User"," Id",userId ));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser = this.userRepository.save(user);
		
		UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
	}
	

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User"," Id",userId ));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream()
				.map(user ->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User"," Id",userId ));
		
		this.userRepository.delete(user);

	}
	
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;
//		
	}

}
