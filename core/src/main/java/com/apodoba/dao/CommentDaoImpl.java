package com.apodoba.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.domain.Comment;
import com.apodoba.domain.User;

@Repository
public class CommentDaoImpl implements CommentDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public boolean addComment(Comment comment) {
		Long id = (Long) sessionFactory.getCurrentSession().save(comment);
		comment.setId(id);
		return id != null ? true: false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllCommentByTicket(long ticketId) {
		Criteria commentsCriteria = sessionFactory.getCurrentSession().createCriteria(Comment.class);
		commentsCriteria.add(Restrictions.eq("ticket.id", ticketId));
		return commentsCriteria.list();
	}

	@Override
	public void update(Comment comment) {
		sessionFactory.getCurrentSession().update(comment);		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Comment> getAllCommentsByUser(User user) {
		Criteria commentsCriteria = sessionFactory.getCurrentSession().createCriteria(Comment.class);
		commentsCriteria.add(Restrictions.eq("employee", user));
		return commentsCriteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllComments() {
		 return sessionFactory.getCurrentSession().createCriteria(Comment.class).list();
	}

	@Override
	public void deleteComment(Comment comment) {
		sessionFactory.getCurrentSession().delete(comment);
	}

	@Override
	public Comment getCommentById(long id) {
		Criteria commentsCriteria = sessionFactory.getCurrentSession().createCriteria(Comment.class);
		commentsCriteria.add(Restrictions.eq("id", id));
		return (Comment) commentsCriteria.uniqueResult();
	}
}
