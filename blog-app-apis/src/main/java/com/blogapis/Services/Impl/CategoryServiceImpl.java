package com.blogapis.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapis.Entities.Category;
import com.blogapis.Exceptions.ResourseNotFoundException;
import com.blogapis.Payloads.CategoryDto;
import com.blogapis.Repositories.CategoryRepository;
import com.blogapis.Services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepository.save(category);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}
	
	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourseNotFoundException("Category"," Id",categoryId ));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat =  this.categoryRepository.save(category);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
		 
	}
	
	

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourseNotFoundException("Category"," Id",categoryId ));
		this.categoryRepository.delete(category);
		

	}
	
	@Override
	public CategoryDto getSingleCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourseNotFoundException("Category"," Id",categoryId ));
		
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategory() {
		List<Category> cat = this.categoryRepository.findAll();
		List<CategoryDto> catd = cat.stream().map((cat1)->this.modelMapper.map(cat1, CategoryDto.class)).collect(Collectors.toList());
		
		
		return catd;
	}




}
