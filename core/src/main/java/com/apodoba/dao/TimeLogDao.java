package com.apodoba.dao;

import com.apodoba.domain.TimeLog;

public interface TimeLogDao {

	boolean addTimeLog(TimeLog timeLog);

	long getTimeLogByTicket(long ticketId);

	void updateTimeLog(TimeLog timeLog);
	
}
