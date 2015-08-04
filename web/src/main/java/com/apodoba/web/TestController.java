package com.apodoba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apodoba.domain.Ticket;
import com.apodoba.service.TicketService;

@Controller
public class TestController {

	@Autowired
	private TicketService ticketService;

	@RequestMapping("/")
	public String home() {
		return "resources/index.html";
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public @ResponseBody List<Ticket> getAllTickets() {
		List<Ticket> tickets = ticketService.getAllTickets();
        return tickets;
    }
	
	@RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET)
    public @ResponseBody Ticket getTicketById(@PathVariable Long ticketId) {
		Ticket ticket = ticketService.getTicketById(ticketId);
        return ticket;
    }

}
