package com.michir.projects.facture.backoffice.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.michir.projects.facture.backoffice.data.Month;
import com.michir.projects.facture.backoffice.data.MonthCalendar;

@Controller
//@RequestMapping("/months")
public class MonthControllers {

	@RequestMapping(value="/month/{year}/{month}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Month getDaysOfMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month, HttpServletResponse response) {
		//response.setHeader("Access-Control-Allow-Origin", "*");
		return new Month(year, month);
	}

	@RequestMapping(value="/calendar/{year}/{month}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MonthCalendar getCalendar(@PathVariable("year") Integer year, @PathVariable("month") Integer month, HttpServletResponse response) {
		return new MonthCalendar(year, month);
	}
	
	@RequestMapping(value="/calendar/save", method=RequestMethod.POST)
	public @ResponseBody Month saveMonth(@RequestBody Month month) {
		return month;
	}
}
