package com.apodoba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class User {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq_gen")
	@SequenceGenerator(name="users_seq_gen", sequenceName="USERS_SEQ")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "POSITION")
	private String position;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
