package com.apodoba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.CommentDao;
import com.apodoba.domain.Comment;
import com.apodoba.domain.User;
import com.apodoba.dto.CommentDto;
import com.apodoba.dto.TicketFullDto;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public CommentDto addComment(String comment, User user, TicketFullDto ticket) {
		Comment newComment = new Comment();
		newComment.setComment(comment);
		newComment.setDate(new Date());
		newComment.setTicket(TicketFullDto.toEntity(ticket));
		newComment.setUser(user);
		
		commentDao.addComment(newComment);
		
		return CommentDto.toDTO(newComment);
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

	@Override
	public void deleteComment(CommentDto comment) {
		Comment dbComment = commentDao.getCommentById(comment.getId());
		commentDao.deleteComment(dbComment);
	}
}
