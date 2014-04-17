package com.apodoba.dao;

import com.apodoba.domain.User;

import java.util.List;

/**
 * Created by apodoba on 4/7/14.
 */
public interface UserDao {

    List<User> getAllUsers();
}
