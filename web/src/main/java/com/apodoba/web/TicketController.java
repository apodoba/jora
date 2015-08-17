package com.apodoba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apodoba.dao.TimeLogDao;
import com.apodoba.dto.CommentDto;
import com.apodoba.dto.TicketFullDto;
import com.apodoba.dto.TicketMainDto;
import com.apodoba.service.CommentService;
import com.apodoba.service.TicketService;
import com.apodoba.service.TimeLogService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/t")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private TimeLogService timeLogService;

	@Autowired
	private TimeLogDao timeLogDao;

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public @ResponseBody List<TicketMainDto> getAllTickets() {
		List<TicketMainDto> tickets = ticketService.getAllTickets();
		return tickets;
	}

	@RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET)
	public @ResponseBody TicketFullDto getTicketById(@PathVariable Long ticketId) throws JsonProcessingException {
		TicketFullDto ticket = ticketService.getTicketById(ticketId);
		return ticket;
	}

	@RequestMapping(value = "/comments/{ticketId}", method = RequestMethod.GET)
	public @ResponseBody List<CommentDto> getAllCommentsForTicket(@PathVariable Long ticketId) {
		List<CommentDto> comments = commentService.getAllCommentByTicket(ticketId);
		return comments;
	}

	@RequestMapping(value = "/logtime/{ticketId}", method = RequestMethod.GET)
	public @ResponseBody long getAllLogTimeForTicket(@PathVariable Long ticketId) {
		long minutes = timeLogService.getTimeLogByTicket(ticketId);
		return minutes;
	}

}
