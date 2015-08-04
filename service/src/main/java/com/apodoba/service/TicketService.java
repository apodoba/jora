package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Ticket;
import com.apodoba.domain.User;

public interface TicketService {
	
	boolean createTicket(Ticket newTicket);
	
	List<Ticket> getAllTickets();
	
	List<Ticket> getTicketsByUser(User user);
	
	void updateTicket(Ticket ticket);
	
	Ticket getTicketById(Long ticketId);

}
