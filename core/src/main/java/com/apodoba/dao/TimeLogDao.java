package com.apodoba.dao;

import com.apodoba.domain.Ticket;
import com.apodoba.domain.TimeLog;


public interface TimeLogDao {
	
	public boolean addTimeLog(TimeLog timeLog);
	public int getTimeLogByTicket(Ticket ticket);
	public void updateTimeLog(TimeLog timeLog);
	
}
