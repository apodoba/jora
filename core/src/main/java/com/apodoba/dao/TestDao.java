package com.apodoba.dao;

import com.apodoba.domain.Ticket;
import com.apodoba.domain.Type;
import com.apodoba.domain.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by apodoba on 3/31/14.
 */
@Repository
public class TestDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int getTypesCount(){
        return sessionFactory.getCurrentSession().createCriteria(Type.class).list().size();
    }
    
    public int getTicketsCount(){
        return sessionFactory.getCurrentSession().createCriteria(Ticket.class).list().size();
    }
    
    public int getUsersCount(){
        return sessionFactory.getCurrentSession().createCriteria(User.class).list().size();
    }
}
