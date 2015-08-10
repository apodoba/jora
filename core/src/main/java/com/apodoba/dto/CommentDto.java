package com.apodoba.dto;

import java.io.Serializable;
import java.util.Date;

import com.apodoba.domain.Comment;

public class CommentDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5879836286776125086L;
	
	private Long id;
	private TicketMainDto ticket;
	private UserDto user;
	private String comment;
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public TicketMainDto getTicket() {
		return ticket;
	}

	public void setTicket(TicketMainDto ticket) {
		this.ticket = ticket;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static CommentDto toDTO(Comment dbComment){
		CommentDto commentDto = new CommentDto();
		commentDto.setUser(UserDto.toDTO(dbComment.getUser()));
		commentDto.setTicket(TicketMainDto.toDTO(dbComment.getTicket()));
		commentDto.setComment(dbComment.getComment());
		commentDto.setDate(dbComment.getDate());
		commentDto.setId(dbComment.getId());
		
		return commentDto;
	}
}
