package com.apodoba.dao;

import java.util.List;

import com.apodoba.domain.Comment;
import com.apodoba.domain.User;

/**
 * Created by apodoba on 4/7/14.
 */
public interface CommentDao {

	boolean addComment(Comment comment);

	List<Comment> getAllCommentByTicket(long ticketId);

	void update(Comment comment);

	List<Comment> getAllCommentsByUser(User user);
	
	List<Comment> getAllComments();

}
