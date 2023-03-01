package com.blogapis.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapis.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
