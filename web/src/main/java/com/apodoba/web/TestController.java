package com.apodoba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
		return "views";
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public @ResponseBody List<Ticket> getAllTickets() {
		List<Ticket> tickets = testService.getAllTickets();
        return tickets;
    }

	@RequestMapping(value = "/getAllProfiles", method = RequestMethod.GET)
	public @ResponseBody String getAllProfiles(ModelMap model) {
		String jsonData = "{\"firstname\":\"ajitesh\",\"lastname\":\"kumar\",\"address\":\"211/20-B,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-888-6666\"}";
		return jsonData;
	}
}
