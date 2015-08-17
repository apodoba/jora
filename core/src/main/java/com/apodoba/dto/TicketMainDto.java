package com.apodoba.dto;

import java.io.Serializable;
import java.util.Date;

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
	private String environment;
	private String resolution;
	private int estimate;
	private Date created;
	private Date updated;

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

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public int getEstimate() {
		return estimate;
	}

	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public static TicketMainDto toDTO(Ticket dbTicket){
		TicketMainDto ticket = new TicketMainDto();
		ticket.setAssignUser(dbTicket.getAssignUser() != null ? UserDto.toDTO(dbTicket.getAssignUser()) : new UserDto());
		ticket.setDescription(dbTicket.getDescription());
		ticket.setId(dbTicket.getId());
		ticket.setName(dbTicket.getName());
		ticket.setPriority(dbTicket.getPriority());
		ticket.setStatus(dbTicket.getStatus());
		ticket.setType(dbTicket.getType());
		ticket.setCreated(dbTicket.getCreated());
		ticket.setEnvironment(dbTicket.getEnvironment());
		ticket.setEstimate(dbTicket.getEstimate());
		ticket.setUpdated(dbTicket.getUpdated());
		ticket.setResolution(dbTicket.getResolution());
		
		return ticket;
	}
	
}
