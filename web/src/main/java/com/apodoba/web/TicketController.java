package com.apodoba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apodoba.domain.Ticket;
import com.apodoba.dto.CommentDto;
import com.apodoba.dto.TicketComment;
import com.apodoba.dto.TicketFullDto;
import com.apodoba.dto.TicketMainDto;
import com.apodoba.service.CommentService;
import com.apodoba.service.TicketService;
import com.apodoba.service.TimeLogService;
import com.apodoba.service.UserService;
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
	private UserService userService;

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
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void editTicket(@RequestBody TicketFullDto ticketFullDto) {
		Ticket ticket = TicketFullDto.toEntity(ticketFullDto);
		ticketService.updateTicket(ticket);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addTicket(@RequestBody TicketFullDto ticketFullDto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		com.apodoba.domain.User dbUser = userService.getUserByEmail(user.getUsername());
		ticketService.createTicket(ticketFullDto, dbUser);
	}
	
	@RequestMapping(value = "/add/comment", method = RequestMethod.POST)
	public @ResponseBody CommentDto addComment(@RequestBody TicketComment ticketComment) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		com.apodoba.domain.User dbUser = userService.getUserByEmail(user.getUsername());
		return commentService.addComment(ticketComment.getComment(), dbUser, ticketComment.getTicket());
	}
	
	@RequestMapping(value = "/delete/comment", method = RequestMethod.POST)
	public boolean deleteComment(@RequestBody CommentDto commentDto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		if(user.getUsername().equals(commentDto.getUser().getEmail())){
			commentService.deleteComment(commentDto);
			return true;
		}
		return false;
	}

}
