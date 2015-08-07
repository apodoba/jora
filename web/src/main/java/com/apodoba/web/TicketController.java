package com.apodoba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apodoba.dao.TimeLogDao;
import com.apodoba.domain.Comment;
import com.apodoba.domain.Ticket;
import com.apodoba.service.CommentService;
import com.apodoba.service.TicketService;
import com.apodoba.service.TimeLogService;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private TimeLogService timeLogService;
	
	@Autowired
	private TimeLogDao timeLogDao;


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
	
	@RequestMapping(value = "/comments/{ticketId}", method = RequestMethod.GET)
    public @ResponseBody List<Comment> getAllCommentsForTicket(@PathVariable Long ticketId) {
		List<Comment> comments = commentService.getAllCommentByTicket(ticketId);
        return comments;
    }
	
	@RequestMapping(value = "/logtime/{ticketId}", method = RequestMethod.GET)
    public @ResponseBody long  getAllLogTimeForTicket(@PathVariable Long ticketId) {
		long minutes = timeLogService.getTimeLogByTicket(ticketId);
        return minutes;
    }

}
