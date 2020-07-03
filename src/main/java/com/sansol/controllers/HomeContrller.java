package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeContrller {
	@RequestMapping("/home")
	public ModelAndView login() {
		System.out.println("you are in home controller");
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}
