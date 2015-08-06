package com.apodoba.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.domain.Comments;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.User;

@Repository
public class CommentDaoImpl implements CommentDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public boolean addComment(Comments comment) {
		return sessionFactory.getCurrentSession().save(comment) != null ? true: false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comments> getAllCommentByTicket(long ticketId) {
		Ticket ticket = (Ticket) sessionFactory.getCurrentSession().get(Ticket.class, ticketId);
		Criteria commentsCriteria = sessionFactory.getCurrentSession().createCriteria(Comments.class);
		commentsCriteria.add(Restrictions.eq("ticket", ticket));
		return commentsCriteria.list();
	}

	@Override
	public void update(Comments comment) {
		sessionFactory.getCurrentSession().update(comment);		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Comments> getAllCommentsByUser(User user) {
		Criteria commentsCriteria = sessionFactory.getCurrentSession().createCriteria(Comments.class);
		commentsCriteria.add(Restrictions.eq("employee", user));
		return commentsCriteria.list();
	}
	
	

}
