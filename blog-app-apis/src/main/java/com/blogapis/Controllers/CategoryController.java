package com.blogapis.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapis.Payloads.ApiResponse;
import com.blogapis.Payloads.CategoryDto;
import com.blogapis.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto categoryDto2 = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(categoryDto2,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryId") Integer catId) {
		CategoryDto updateCat = this.categoryService.updateCategory(categoryDto, catId);
		return ResponseEntity.ok(updateCat);
	}
	
	
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Integer catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted SuccessFully",true),HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return ResponseEntity.ok(this.categoryService.getCategory());
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable("catId") Integer catId) {
		CategoryDto categoryDto = this.categoryService.getSingleCategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}	

}
