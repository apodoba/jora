package com.apodoba.dao;

import java.util.List;

import com.apodoba.domain.Comments;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.User;

/**
 * Created by apodoba on 4/7/14.
 */
public interface CommentDao {

	boolean addComment(Comments comment);

	List<Comments> getAllCommentByTicket(Ticket ticket);

	void update(Comments comment);

	List<Comments> getAllCommentsByUser(User user);

}
