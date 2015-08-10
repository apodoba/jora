package com.apodoba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.CommentDao;
import com.apodoba.domain.Comment;
import com.apodoba.dto.CommentDto;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public boolean addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	@Override
	public List<CommentDto> getAllCommentByTicket(long ticketId) {
		List<CommentDto> comments = new ArrayList<CommentDto>();
		for (Comment comment : commentDao.getAllCommentByTicket(ticketId)) {
			comments.add(CommentDto.toDTO(comment));
		}
		return comments;
	}

	@Override
	public void update(Comment comment) {
		commentDao.update(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		return commentDao.getAllComments();
	}

}
