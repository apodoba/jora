package com.apodoba.dto;

public class TicketComment {

	private TicketFullDto ticket;
	private String comment;

	public TicketFullDto getTicket() {
		return ticket;
	}

	public void setTicket(TicketFullDto ticket) {
		this.ticket = ticket;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
