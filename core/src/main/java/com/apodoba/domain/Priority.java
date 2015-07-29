package com.apodoba.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRIORITY")
public class Priority implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -647137484613301485L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="priority_seq_gen")
	@SequenceGenerator(name="priority_seq_gen", sequenceName="PRIORITY_SEQ")
	private Long id;
	
	@Column(name = "PRIORITY", nullable= false, length = 50)
	private String priority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
