package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Comment;
import com.apodoba.dto.CommentDto;

public interface CommentService {
	
	boolean addComment(Comment comment);

	List<CommentDto> getAllCommentByTicket(long ticketId);

	void update(Comment comment);
	
	List<Comment> getAllComments();
}
