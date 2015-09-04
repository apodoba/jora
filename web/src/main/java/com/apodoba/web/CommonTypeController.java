package com.apodoba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apodoba.domain.Priority;
import com.apodoba.domain.Status;
import com.apodoba.domain.Type;
import com.apodoba.service.CommonTypeService;

@RestController
@RequestMapping(value = "/type")
public class CommonTypeController {

	@Autowired
	private CommonTypeService commonTypeService;
	
	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public @ResponseBody List<Type> getAllTicketTypes() {
		List<Type> ticketTypes = commonTypeService.getAllTypes();
		return ticketTypes;
	}
	
	@RequestMapping(value = "/statuses", method = RequestMethod.GET)
	public @ResponseBody List<Status> getAllTicketStatus() {
		List<Status> ticketStatus = commonTypeService.getAllStatus();
		return ticketStatus;
	}
	
	@RequestMapping(value = "/priorities", method = RequestMethod.GET)
	public @ResponseBody List<Priority> getAllTicketPriorities() {
		List<Priority> ticketPriorities = commonTypeService.getAllPriorities();
		return ticketPriorities;
	}
	
}
