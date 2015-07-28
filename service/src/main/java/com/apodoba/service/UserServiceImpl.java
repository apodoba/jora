package com.apodoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.UserDao;
import com.apodoba.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}
	
}
