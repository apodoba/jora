package com.apodoba.dto;

import java.io.Serializable;

import com.apodoba.domain.User;

public class UserDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 438599456462842305L;

	private Long id;
	private String name;
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

	public static UserDto toDTO(User dbUser){
		UserDto userDto = new UserDto();
		userDto.setId(dbUser.getId());
		userDto.setName(dbUser.getName());
		userDto.setPosition(dbUser.getPosition());
		return userDto;
	}
}
