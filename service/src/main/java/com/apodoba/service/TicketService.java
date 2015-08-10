package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Ticket;
import com.apodoba.domain.User;
import com.apodoba.dto.TicketFullDto;
import com.apodoba.dto.TicketMainDto;

public interface TicketService {
	
	boolean createTicket(Ticket newTicket);
	
	List<TicketMainDto> getAllTickets();
	
	List<Ticket> getTicketsByUser(User user);
	
	void updateTicket(Ticket ticket);
	
	TicketFullDto getTicketById(Long ticketId);

}
