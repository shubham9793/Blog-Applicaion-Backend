package com.blogapis.Payloads;



import javax.validation.constraints.Size;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
public class UserDto {
	
	
	private int id;
	
	@NotEmpty
	@Size(min=4,message="Name must be min of 4 characters")
	private String name;
	
	@Email(message="Email Address is not Valid!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=12, message="Password cantaine min 3 and max 12 characters!")
	private String password;
	
	@NotEmpty
	private String about;
}