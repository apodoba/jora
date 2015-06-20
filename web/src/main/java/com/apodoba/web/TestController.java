package com.apodoba.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apodoba.service.TestService;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/tickets")
	public int getAllTickets() {
		return testService.getAllTickets().size();
	}
}
