package com.apodoba.dao;

import com.apodoba.domain.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apodoba on 4/7/14.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

	@Override
	public User getUserById(Long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
}
