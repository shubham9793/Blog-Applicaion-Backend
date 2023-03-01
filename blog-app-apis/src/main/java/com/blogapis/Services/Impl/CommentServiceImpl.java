package com.blogapis.Services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapis.Entities.Comment;
import com.blogapis.Entities.Post;
import com.blogapis.Exceptions.ResourseNotFoundException;
import com.blogapis.Payloads.CommentDto;
import com.blogapis.Repositories.CommentRepository;
import com.blogapis.Repositories.PostRepository;
import com.blogapis.Services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourseNotFoundException("Post","Post Id",postId ));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		Comment saveComments = this.commentRepository.save(comment);
		
		return this.modelMapper.map(saveComments, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourseNotFoundException("Comment","Comment Id",commentId ));
		this.commentRepository.delete(comment);
		
	} 
	

}
