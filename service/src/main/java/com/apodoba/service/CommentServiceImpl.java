package com.apodoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.CommentDao;
import com.apodoba.domain.Comments;
import com.apodoba.domain.Ticket;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public boolean addComment(Comments comment) {
		return commentDao.addComment(comment);
	}

	@Override
	public List<Comments> getAllCommentByTicket(Ticket ticket) {
		return commentDao.getAllCommentByTicket(ticket);
	}

	@Override
	public void update(Comments comment) {
		commentDao.update(comment);
	}

}
