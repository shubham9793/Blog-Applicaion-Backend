package com.blogapis.Services;

import java.util.List;

import com.blogapis.Entities.Post;
import com.blogapis.Payloads.PostDto;


public interface PostService {
	
	// create User
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	
	// Update post
	PostDto UpdatePost(PostDto postDto,Integer postId);
	
	
	// Delete Post
	void deletePost(Integer postId);
	
	//Get All post
	
	List<PostDto> getAllPost(Integer pageNumber,Integer pageSize);
	
	
	// Get Single post
	
	PostDto getPostById(Integer postId);
	
	
	// Get All post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// Get All post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	
	// Search post by its keywords
	List<Post> searchPost(String keyword);
}
