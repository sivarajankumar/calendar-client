package com.michir.projects.facture.backoffice.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.michir.projects.facture.backoffice.data.Person;

@Controller
public class TestController {

	@RequestMapping(value="/person/post", method=RequestMethod.POST)
	public @ResponseBody void save(@RequestBody Collection<Person> persons) {
		System.out.println(persons.size());
	}
}
