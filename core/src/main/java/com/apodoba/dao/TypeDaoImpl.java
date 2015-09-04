package com.apodoba.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apodoba.domain.Type;


@Repository
public class TypeDaoImpl implements TypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> getAllTypes() {
		return sessionFactory.getCurrentSession().createCriteria(Type.class).list();
	}

}