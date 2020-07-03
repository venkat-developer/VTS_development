package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		System.out.println("you are in LoginController");
		ModelAndView mav = new ModelAndView();
		mav.addObject("home");
		return "home";
	}
	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("home");
		return mav;
	}
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("register");
		return mav;
	}
}
