package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Comment;
import com.apodoba.domain.User;
import com.apodoba.dto.CommentDto;
import com.apodoba.dto.TicketFullDto;

public interface CommentService {
	
	CommentDto addComment(String comment, User user, TicketFullDto ticket);

	List<CommentDto> getAllCommentByTicket(long ticketId);

	void update(Comment comment);
	
	List<Comment> getAllComments();
	
	void deleteComment(CommentDto comment);
}
