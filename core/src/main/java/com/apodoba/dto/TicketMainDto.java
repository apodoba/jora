package com.apodoba.dto;

import java.io.Serializable;

import com.apodoba.domain.Priority;
import com.apodoba.domain.Status;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.Type;

public class TicketMainDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 392183528274127210L;
	
	private Long id;
	private String name;
	private Priority priority;
	private String description;
	private Type type;
	private Status status;
	private UserDto assignUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserDto getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(UserDto assignUser) {
		this.assignUser = assignUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static TicketMainDto toDTO(Ticket dbTicket){
		TicketMainDto ticketFull = new TicketMainDto();
		ticketFull.setAssignUser(dbTicket.getAssignUser() != null ? UserDto.toDTO(dbTicket.getAssignUser()) : new UserDto());
		ticketFull.setDescription(dbTicket.getDescription());
		ticketFull.setId(dbTicket.getId());
		ticketFull.setName(dbTicket.getName());
		ticketFull.setPriority(dbTicket.getPriority());
		ticketFull.setStatus(dbTicket.getStatus());
		ticketFull.setType(dbTicket.getType());
		
		return ticketFull;
	}
	
}
