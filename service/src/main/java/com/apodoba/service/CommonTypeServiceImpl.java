package com.apodoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apodoba.dao.PriorityDao;
import com.apodoba.dao.StatusDao;
import com.apodoba.dao.TypeDao;
import com.apodoba.domain.Priority;
import com.apodoba.domain.Status;
import com.apodoba.domain.Type;

@Service
@Transactional
public class CommonTypeServiceImpl implements CommonTypeService{

	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private StatusDao statusDao;
	
	@Autowired
	private PriorityDao priorityDao;
	
	@Override
	public List<Priority> getAllPriorities() {
		return priorityDao.getAllPriorities();
	}

	@Override
	public List<Status> getAllStatus() {
		return statusDao.getAllStatus();
	}

	@Override
	public List<Type> getAllTypes() {
		return typeDao.getAllTypes();
	}

}
