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

	List<Ticket> getAllTickets();

	List<Ticket> getAllTicketsByUser(User user);

	List<Ticket> getAllTicketsByType(Type type);

	List<Ticket> getAllTicketsByStatus(Status status);

	boolean addTicket(Ticket ticket);

	void updateTicket(Ticket ticket);

}
