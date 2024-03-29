package com.michir.projects.facture.backoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/base")
public class BaseController {

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String get(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		return "base";
	}

}
