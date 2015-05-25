package com.apodoba.dao;

import com.apodoba.domain.Status;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.Type;
import com.apodoba.domain.User;

import java.util.List;

/**
 * Created by apodoba on 4/7/14.
 */
public interface TicketDao {

    public List<Ticket> getAllTickets();
    public List<Ticket> getAllTicketsByUser(User user);
    public List<Ticket> getAllTicketsByType(Type type);
    public List<Ticket> getAllTicketsByStatus(Status status);
    public boolean addTicket(Ticket ticket);
    public void updateTicket(Ticket ticket);
    
}
