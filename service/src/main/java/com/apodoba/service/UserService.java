package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.User;

public interface UserService {
	
	List<User> getAllUsers();

	User getUserById(Long id);
}
