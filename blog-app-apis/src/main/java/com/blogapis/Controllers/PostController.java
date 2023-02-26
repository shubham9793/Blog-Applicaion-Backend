package com.blogapis.Controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapis.Payloads.ApiResponse;
import com.blogapis.Payloads.PostDto;
import com.blogapis.Services.PostService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId) {
		
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	
	
	// get By Users
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	
	// Get post by category
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	// Get All Post
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(
			@RequestParam(value="pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue = "5",required = false) Integer pageSize
			) {
		List<PostDto> allPost =  this.postService.getAllPost(pageNumber,pageSize);
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
	}
	
	// Get Single post or Get post details by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	
	// delete Post
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post is Suceessfull deleted!", true);
		
	}
	
	
	// Update Post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatePost = this.postService.UpdatePost(postDto, postId);
		return  new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
		
	}
	
}
