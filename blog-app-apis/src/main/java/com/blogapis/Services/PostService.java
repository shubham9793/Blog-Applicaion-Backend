package com.blogapis.Services;

import java.util.List;

import com.blogapis.Payloads.PostDto;
import com.blogapis.Payloads.PostResponse;


public interface PostService {
	
	// create User
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	
	// Update post
	PostDto UpdatePost(PostDto postDto,Integer postId);
	
	
	// Delete Post
	void deletePost(Integer postId);
	
	//Get All post
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	
	// Get Single post
	
	PostDto getPostById(Integer postId);
	
	
	// Get All post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// Get All post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	
	// Search post by its keywords
	List<PostDto> searchPost(String keyword);
}
