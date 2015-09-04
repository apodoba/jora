package com.apodoba.service;

import java.util.List;

import com.apodoba.domain.Priority;
import com.apodoba.domain.Status;
import com.apodoba.domain.Type;

public interface CommonTypeService {

	List<Priority> getAllPriorities();
	
	List<Status> getAllStatus();
	
	List<Type> getAllTypes();
}
