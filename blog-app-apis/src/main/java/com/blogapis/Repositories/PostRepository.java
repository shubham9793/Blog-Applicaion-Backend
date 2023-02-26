package com.blogapis.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapis.Entities.Category;
import com.blogapis.Entities.Post;
import com.blogapis.Entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	
}
