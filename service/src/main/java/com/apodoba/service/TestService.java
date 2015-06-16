package com.apodoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.TicketDao;
import com.apodoba.domain.Ticket;

@Service
public class TestService {
	
	@Autowired
    private TicketDao ticketDao;
	
	@Transactional
	public List<Ticket> getAllTickets(){
		return ticketDao.getAllTickets();
	}
}
