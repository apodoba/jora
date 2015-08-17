package com.apodoba.dto;

import java.io.Serializable;
import java.util.Date;
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

	public static TicketFullDto toDTO(Ticket dbTicket){
		TicketFullDto ticket = new TicketFullDto();
		ticket.setAssignUser(dbTicket.getAssignUser() != null ? UserDto.toDTO(dbTicket.getAssignUser()) : new UserDto());
		ticket.setCreatedUser(UserDto.toDTO(dbTicket.getCreatedUser()));
		ticket.setDescription(dbTicket.getDescription());
		ticket.setId(dbTicket.getId());
		ticket.setName(dbTicket.getName());
		ticket.setParent(dbTicket.getParent() != null ? TicketMainDto.toDTO(dbTicket.getParent()) : null);
		ticket.setPriority(dbTicket.getPriority());
		ticket.setStatus(dbTicket.getStatus());
		ticket.setType(dbTicket.getType());
		ticket.setCreated(dbTicket.getCreated());
		ticket.setEnvironment(dbTicket.getEnvironment());
		ticket.setEstimate(dbTicket.getEstimate());
		ticket.setUpdated(dbTicket.getUpdated());
		ticket.setResolution(dbTicket.getResolution());
		
		Set<TicketMainDto> related = new HashSet<TicketMainDto>();
		for(Ticket ticketChild: dbTicket.getRelatedTickets()){
			related.add(TicketMainDto.toDTO(ticketChild));
		}
		ticket.setRelatedTickets(related);
		
		related = new HashSet<TicketMainDto>();
		for(Ticket ticketChild: dbTicket.getChildren()){
			related.add(TicketMainDto.toDTO(ticketChild));
		}
		ticket.setChildren(related);
		
		return ticket;
	}

}
