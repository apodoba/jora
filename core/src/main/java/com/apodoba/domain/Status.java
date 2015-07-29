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
@Table(name = "STATUS")
public class Status implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2251916740524116801L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status_seq_gen")
	@SequenceGenerator(name="status_seq_gen", sequenceName="STATUS_SEQ")
	private Long id;
	
	@Column(name = "STATUS", nullable= false, length = 50)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
