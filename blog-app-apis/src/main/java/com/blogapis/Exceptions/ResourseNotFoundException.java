package com.blogapis.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourseNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;;
	long fieldValue;
	
	
	public ResourseNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found With %s : %s", resourceName,fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
}
