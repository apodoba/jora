package com.apodoba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.TicketDao;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.User;
import com.apodoba.dto.TicketFullDto;
import com.apodoba.dto.TicketMainDto;
import com.apodoba.dto.UserDto;

@Service
@Transactional
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketDao ticketDao;

	@Override
	public boolean createTicket(TicketFullDto ticket, User user) {
		ticket.setCreatedUser(UserDto.toDTO(user));
		
		Ticket newTicket = TicketFullDto.toEntity(ticket);
		newTicket.setCreated(new Date());
		newTicket.setUpdated(new Date());
		newTicket.setResolution("Unresolved");
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
		ticket.setUpdated(new Date());
		ticketDao.updateTicket(ticket);
	}

	@Override
	public TicketFullDto getTicketById(Long ticketId) {
		Ticket dbTicket = ticketDao.getTicketById(ticketId);
		TicketFullDto ticketFull = TicketFullDto.toDTO(dbTicket);
		return ticketFull;
	}

}
