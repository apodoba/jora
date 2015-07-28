package com.apodoba.service;

import com.apodoba.domain.Ticket;
import com.apodoba.domain.TimeLog;

public interface TimeLogService {
	
	boolean addTimeLog(TimeLog timeLog);

	int getTimeLogByTicket(Ticket ticket);

	void updateTimeLog(TimeLog timeLog);
}
