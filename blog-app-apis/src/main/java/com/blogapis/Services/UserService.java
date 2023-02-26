package com.blogapis.Services;



import java.util.List;

import com.blogapis.Payloads.UserDto;



public interface UserService {
	
	UserDto createUser(UserDto user) ;
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer userId);
	
	

}