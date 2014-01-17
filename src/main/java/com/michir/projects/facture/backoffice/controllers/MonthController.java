package com.michir.projects.facture.backoffice.controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.michir.projects.facture.backoffice.dao.MonthDao;
import com.michir.projects.facture.backoffice.data.MonthCalendar;
import com.michir.projects.facture.backoffice.data.MonthEntry;
import com.michir.projects.facture.backoffice.data.Status;

@Controller
public class MonthController {

	private MonthDao monthDao = new MonthDao();
	
	@RequestMapping(value="/calendar/get/{year}/{month}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MonthCalendar getCalendar(@PathVariable("year") Integer year, @PathVariable("month") Integer month, HttpServletResponse response) throws Exception {
		MonthCalendar monthCalendar = monthDao.load(year, month);
		if (monthCalendar != null) {
			return monthCalendar;
		} else {
			return new MonthCalendar(year, month);
		}
	}

	@RequestMapping(value="/calendar/getAll", method=RequestMethod.GET)
	public @ResponseBody Collection<MonthEntry> getAll() throws Exception {
		return monthDao.loadAll(0, 12);
	}
	
	@RequestMapping(value="/calendar/save", method=RequestMethod.POST)
	public @ResponseBody Status saveMonth(@RequestBody MonthCalendar month) {
		try {
			monthDao.save(month);
			return Status.valueOf("OK", 0);
		} catch (Exception e) {
			return Status.valueOf(e.getMessage(), -1);
		}
	}
}
