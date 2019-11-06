package com.hampcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
	
	protected static final String INDEX_VIEW = "index"; 
	
	@GetMapping
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(INDEX_VIEW);
		return modelAndView;
	}
}