package com.apodoba.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apodoba.domain.Priority;

@Repository
public class PriorityDaoImpl implements PriorityDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Priority> getAllPriorities() {
		return sessionFactory.getCurrentSession().createCriteria(Priority.class).list();
	}

}
