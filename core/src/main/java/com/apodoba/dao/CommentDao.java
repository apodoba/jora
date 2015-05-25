package com.apodoba.dao;

import java.util.List;

import com.apodoba.domain.Comments;
import com.apodoba.domain.Ticket;

/**
 * Created by apodoba on 4/7/14.
 */
public interface CommentDao {
	
	public boolean addComment(Comments comment);
	public List<Comments> getAllCommentByTicket(Ticket ticket);
	public void update(Comments comment);
	
}
