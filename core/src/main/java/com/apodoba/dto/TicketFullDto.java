package com.apodoba.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.apodoba.domain.Priority;
import com.apodoba.domain.Status;
import com.apodoba.domain.Ticket;
import com.apodoba.domain.Type;

public class TicketFullDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4376045118555908328L;
	
	private Long id;
	private String name;
	private Priority priority;
	private String description;
	private Type type;
	private Status status;
	private UserDto createdUser;
	private UserDto assignUser;
	private Set<TicketMainDto> children;
	private TicketMainDto parent;
	private Set<TicketMainDto> relatedTickets;

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

	public UserDto getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(UserDto createdUser) {
		this.createdUser = createdUser;
	}

	public UserDto getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(UserDto assignUser) {
		this.assignUser = assignUser;
	}

	public Set<TicketMainDto> getChildren() {
		return children;
	}

	public void setChildren(Set<TicketMainDto> children) {
		this.children = children;
	}

	public TicketMainDto getParent() {
		return parent;
	}

	public void setParent(TicketMainDto parent) {
		this.parent = parent;
	}

	public Set<TicketMainDto> getRelatedTickets() {
		return relatedTickets;
	}

	public void setRelatedTickets(Set<TicketMainDto> relatedTickets) {
		this.relatedTickets = relatedTickets;
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
	
	public static TicketFullDto toDTO(Ticket dbTicket){
		TicketFullDto ticketFull = new TicketFullDto();
		ticketFull.setAssignUser(dbTicket.getAssignUser() != null ? UserDto.toDTO(dbTicket.getAssignUser()) : new UserDto());
		ticketFull.setCreatedUser(UserDto.toDTO(dbTicket.getCreatedUser()));
		ticketFull.setDescription(dbTicket.getDescription());
		ticketFull.setId(dbTicket.getId());
		ticketFull.setName(dbTicket.getName());
		ticketFull.setParent(dbTicket.getParent() != null ? TicketMainDto.toDTO(dbTicket.getParent()) : null);
		ticketFull.setPriority(dbTicket.getPriority());
		ticketFull.setStatus(dbTicket.getStatus());
		ticketFull.setType(dbTicket.getType());
		
		Set<TicketMainDto> related = new HashSet<TicketMainDto>();
		for(Ticket ticket: dbTicket.getRelatedTickets()){
			related.add(TicketMainDto.toDTO(ticket));
		}
		ticketFull.setRelatedTickets(related);
		
		related = new HashSet<TicketMainDto>();
		for(Ticket ticket: dbTicket.getChildren()){
			related.add(TicketMainDto.toDTO(ticket));
		}
		ticketFull.setChildren(related);
		
		return ticketFull;
	}

}
