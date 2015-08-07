package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Comment;

public interface CommentService {
	
	boolean addComment(Comment comment);

	List<Comment> getAllCommentByTicket(long ticketId);

	void update(Comment comment);
	
	List<Comment> getAllComments();
}
