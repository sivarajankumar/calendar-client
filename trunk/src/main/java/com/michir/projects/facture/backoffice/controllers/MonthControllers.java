package com.michir.projects.facture.backoffice.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.michir.projects.facture.backoffice.data.Day;

@Controller
@RequestMapping("/months")
public class MonthControllers {

	@RequestMapping(value="/{month}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> getDays(@PathVariable("month") Integer month, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("days", Arrays.asList(new Day("Lundi")));
		return map;
	}
}
