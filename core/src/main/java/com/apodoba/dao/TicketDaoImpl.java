package com.apodoba.dao;

import com.apodoba.domain.Status;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.Type;
import com.apodoba.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apodoba on 4/7/14.
 */
@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Ticket> getAllTickets() {
        return sessionFactory.getCurrentSession().createCriteria(Ticket.class).list();
    }

    @Override
    public List<Ticket> getAllTicketsByUser(User user) {
        return null;
    }

    @Override
    public List<Ticket> getAllTicketsByType(Type type) {
        return null;
    }

    @Override
    public List<Ticket> getAllTicketsByStatus(Status type) {
        return null;
    }
}
