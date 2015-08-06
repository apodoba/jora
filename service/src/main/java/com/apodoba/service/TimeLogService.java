package com.apodoba.service;

import com.apodoba.domain.TimeLog;

public interface TimeLogService {
	
	boolean addTimeLog(TimeLog timeLog);

	long getTimeLogByTicket(long ticketId);

	void updateTimeLog(TimeLog timeLog);
}
