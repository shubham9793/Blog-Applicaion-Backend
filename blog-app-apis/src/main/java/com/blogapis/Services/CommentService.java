package com.blogapis.Services;

import com.blogapis.Payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto ,Integer postId) ;
	
	void deleteComment(Integer commentId);
}