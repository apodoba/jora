package com.apodoba.dto;

import java.io.Serializable;

import com.apodoba.domain.Role;
import com.apodoba.domain.User;

public class UserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 438599456462842305L;

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String position;
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static UserDto toDTO(User dbUser) {
		UserDto userDto = new UserDto();
		userDto.setId(dbUser.getId());
		userDto.setEmail(dbUser.getEmail());
		userDto.setFirstName(dbUser.getFirstName());
		userDto.setLastName(dbUser.getLastName());
		userDto.setPassword(dbUser.getPassword());
		userDto.setRole(dbUser.getRole());
		userDto.setPosition(dbUser.getPosition());
		return userDto;
	}
}
