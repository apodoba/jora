package com.apodoba.dao;

import com.apodoba.domain.Ticket;
import com.apodoba.domain.TimeLog;

public interface TimeLogDao {

	boolean addTimeLog(TimeLog timeLog);

	int getTimeLogByTicket(Ticket ticket);

	void updateTimeLog(TimeLog timeLog);

}
