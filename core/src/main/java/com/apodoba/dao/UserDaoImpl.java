package com.apodoba.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apodoba.domain.User;

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

	@Override
	public User getUserByEmail(String mail) {
		Criteria userCriteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		userCriteria.add(Restrictions.eq("email", mail));
    	return (User) userCriteria.uniqueResult();
	}
}
