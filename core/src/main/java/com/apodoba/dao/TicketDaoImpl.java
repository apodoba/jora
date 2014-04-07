package com.apodoba.dao;

import com.apodoba.domain.Status;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.Type;
import com.apodoba.domain.User;

import java.util.List;

/**
 * Created by apodoba on 4/7/14.
 */
public class TicketDaoImpl implements TicketDao {
    @Override
    public List<Ticket> getAllTickets() {
        return null;
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
