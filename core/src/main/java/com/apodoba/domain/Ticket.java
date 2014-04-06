package com.apodoba.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticket_seq_gen")
	@SequenceGenerator(name="ticket_seq_gen", sequenceName="TICKET_SEQ")
	private Integer id;

	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private Type userRole;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_EMPLOYEE", nullable = false)
	private User createdUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGN_EMPLOYEE", nullable = false)
	private User assignUser;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "HIERARCHY", joinColumns = { @JoinColumn(name = "PARENT") }, inverseJoinColumns = { @JoinColumn(name = "TICKET") })
	private List<Ticket> children;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "HIERARCHY", joinColumns = { @JoinColumn(name = "TICKET") }, inverseJoinColumns = { @JoinColumn(name = "PARENT") })
	private Ticket parent;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RELATIONS", joinColumns = { @JoinColumn(name = "TICKET") }, inverseJoinColumns = { @JoinColumn(name = "RELATED") })
	private List<Ticket> relatedTickets;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Type getUserRole() {
		return userRole;
	}

	public void setUserRole(Type userRole) {
		this.userRole = userRole;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	public User getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(User assignUser) {
		this.assignUser = assignUser;
	}

	public List<Ticket> getChildren() {
		return children;
	}

	public void setChildren(List<Ticket> children) {
		this.children = children;
	}

	public Ticket getParent() {
		return parent;
	}

	public void setParent(Ticket parent) {
		this.parent = parent;
	}

	public List<Ticket> getRelatedTickets() {
		return relatedTickets;
	}

	public void setRelatedTickets(List<Ticket> relatedTickets) {
		this.relatedTickets = relatedTickets;
	}

}
