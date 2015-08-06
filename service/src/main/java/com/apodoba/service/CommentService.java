package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Comments;

public interface CommentService {
	
	boolean addComment(Comments comment);

	List<Comments> getAllCommentByTicket(long ticketId);

	void update(Comments comment);
}
