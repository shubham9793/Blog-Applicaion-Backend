package com.blogapis.Services;

import java.util.List;

import com.blogapis.Payloads.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);
	
	void deleteCategory(Integer categoryId);
	
	CategoryDto getSingleCategory(Integer categoryId);
	
	List<CategoryDto> getCategory();

}
