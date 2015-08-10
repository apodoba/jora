package com.apodoba.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -789928061731312084L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticket_seq_gen")
	@SequenceGenerator(name="ticket_seq_gen", sequenceName="TICKET_SEQ")
	private Long id;
	
	@Column(name = "NAME", nullable= false)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRIORITY", nullable = false)
	private Priority priority;
	
	@Column(name = "DESCRIPTION", nullable= false)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE", nullable = false)
	private Type type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATUS", nullable = false)
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_EMPLOYEE", nullable = false)
	private User createdUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ASSIGN_EMPLOYEE", nullable = false)
	private User assignUser;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "HIERARCHY", joinColumns = { @JoinColumn(name = "PARENT") }, inverseJoinColumns = { @JoinColumn(name = "TICKET") })
	private Set<Ticket> children;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "HIERARCHY", joinColumns = { @JoinColumn(name = "TICKET") }, inverseJoinColumns = { @JoinColumn(name = "PARENT") })
	private Ticket parent;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RELATIONS", joinColumns = { @JoinColumn(name = "TICKET") }, inverseJoinColumns = { @JoinColumn(name = "RELATED") })
	private Set<Ticket> relatedTickets;

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

	public Set<Ticket> getChildren() {
		return children;
	}

	public void setChildren(Set<Ticket> children) {
		this.children = children;
	}

	public Ticket getParent() {
		return parent;
	}

	public void setParent(Ticket parent) {
		this.parent = parent;
	}

	public Set<Ticket> getRelatedTickets() {
		return relatedTickets;
	}

	public void setRelatedTickets(Set<Ticket> relatedTickets) {
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

}
