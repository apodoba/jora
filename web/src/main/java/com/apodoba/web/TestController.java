package com.apodoba.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apodoba.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/")
    public String home() {
		System.out.println(testService.getAllTickets().size());
		return "views";
    }    
    
	@RequestMapping(value = "/test/tickets")
	public int getAllTickets() {
		return testService.getAllTickets().size();
	}
}
