package com.apodoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.TicketDao;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.User;

@Service
@Transactional
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketDao ticketDao;

	@Override
	public boolean createTicket(Ticket newTicket) {
		return ticketDao.addTicket(newTicket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketDao.getAllTickets();
	}

	@Override
	public List<Ticket> getTicketsByUser(User user) {
		return ticketDao.getAllTicketsByUser(user);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketDao.updateTicket(ticket);
	}

}
