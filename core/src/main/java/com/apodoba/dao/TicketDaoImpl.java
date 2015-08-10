package com.apodoba.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apodoba.domain.Status;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.Type;
import com.apodoba.domain.User;

/**
 * Created by apodoba on 4/7/14.
 */
@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List<Ticket> getAllTickets() {
        return sessionFactory.getCurrentSession().createCriteria(Ticket.class).list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Ticket> getAllTicketsByUser(User user) {
    	Criteria ticketCriteria = sessionFactory.getCurrentSession().createCriteria(Ticket.class);
    	ticketCriteria.add(Restrictions.eq("assignUser", user));
    	return ticketCriteria.list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Ticket> getAllTicketsByType(Type type) {
    	Criteria ticketCriteria = sessionFactory.getCurrentSession().createCriteria(Ticket.class);
    	ticketCriteria.add(Restrictions.eq("type", type));
    	return ticketCriteria.list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Ticket> getAllTicketsByStatus(Status status) {
    	Criteria ticketCriteria = sessionFactory.getCurrentSession().createCriteria(Ticket.class);
    	ticketCriteria.add(Restrictions.eq("status", status));
    	return ticketCriteria.list();
    }

	@Override
	public boolean addTicket(Ticket ticket) {
		return sessionFactory.getCurrentSession().save(ticket) != null ? true: false;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		sessionFactory.getCurrentSession().update(ticket);
	}

	@Override
	public Ticket getTicketById(Long ticketId) {
		Ticket ticket = (Ticket) sessionFactory.getCurrentSession().get(Ticket.class, ticketId);
		return ticket;
	}
}
