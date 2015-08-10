package com.apodoba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.TicketDao;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.User;
import com.apodoba.dto.TicketFullDto;
import com.apodoba.dto.TicketMainDto;

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
	public List<TicketMainDto> getAllTickets() {
		List<TicketMainDto> tickets = new ArrayList<TicketMainDto>();
		for(Ticket ticket: ticketDao.getAllTickets()){
			tickets.add(TicketMainDto.toDTO(ticket));
		}
		return tickets;
	}

	@Override
	public List<Ticket> getTicketsByUser(User user) {
		return ticketDao.getAllTicketsByUser(user);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketDao.updateTicket(ticket);
	}

	@Override
	public TicketFullDto getTicketById(Long ticketId) {
		Ticket dbTicket = ticketDao.getTicketById(ticketId);
		TicketFullDto ticketFull = TicketFullDto.toDTO(dbTicket);
		return ticketFull;
	}

}
