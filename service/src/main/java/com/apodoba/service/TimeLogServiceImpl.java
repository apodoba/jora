package com.apodoba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.TimeLogDao;
import com.apodoba.domain.TimeLog;

@Service
@Transactional
public class TimeLogServiceImpl implements TimeLogService{
	
	@Autowired
	TimeLogDao timeLogDao;

	@Override
	public boolean addTimeLog(TimeLog timeLog) {
		return timeLogDao.addTimeLog(timeLog);
	}

	@Override
	public long getTimeLogByTicket(long ticketId) {
		return timeLogDao.getTimeLogByTicket(ticketId);
	}

	@Override
	public void updateTimeLog(TimeLog timeLog) {
		timeLogDao.updateTimeLog(timeLog);
	}

}
