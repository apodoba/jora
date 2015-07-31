package com.apodoba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apodoba.domain.Ticket;
import com.apodoba.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/")
	public String home() {
		return "views/index.html";
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public @ResponseBody List<Ticket> getAllTickets() {
		List<Ticket> tickets = testService.getAllTickets();
        return tickets;
    }

}
