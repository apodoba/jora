package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Comments;
import com.apodoba.domain.Ticket;

public interface CommentService {
	
	boolean addComment(Comments comment);

	List<Comments> getAllCommentByTicket(Ticket ticket);

	void update(Comments comment);
}
