package com.blogapis.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogapis.Entities.Category;
import com.blogapis.Entities.Post;
import com.blogapis.Entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	// Searching quarry
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title) ;
}
