package com.apodoba.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by apodoba on 3/31/14.
 */
@Entity
@Table(name = "TYPE")
public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8915691439701181820L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="type_seq_gen")
	@SequenceGenerator(name="type_seq_gen", sequenceName="TYPE_SEQ")
	private Long id;
	
	@Column(name = "TYPE", nullable= false, length = 50)
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
