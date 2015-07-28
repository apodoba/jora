package com.apodoba.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apodoba.domain.Ticket;
import com.apodoba.domain.TimeLog;

@Repository
public class TimeLogDaoImpl implements TimeLogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addTimeLog(TimeLog timeLog) {
		return sessionFactory.getCurrentSession().save(timeLog) != null ? true: false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTimeLogByTicket(Ticket ticket) {
		Criteria logTimeCriteria = sessionFactory.getCurrentSession().createCriteria(TimeLog.class);
		logTimeCriteria.add(Restrictions.eq("ticket", ticket));
		logTimeCriteria.setProjection(Projections.sum("minutes"));
		List<Integer> totalLogTime = logTimeCriteria.list();
		return totalLogTime.get(0);
	}

	@Override
	public void updateTimeLog(TimeLog timeLog) {
		sessionFactory.getCurrentSession().update(timeLog);
	}

}
