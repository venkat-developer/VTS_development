package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@RequestMapping("/customer")
	public String userController() {
		System.out.println("you are in CustomerController");
		ModelAndView mav = new ModelAndView();
		mav.addObject("home");
		//There is some problem in returning ModeAndView object hence returning jsp page name.
		return "customerControlPanel";
	}
	@RequestMapping("/addCustomer")
	public ModelAndView addUser() {
		System.out.println("you are in CustomerController addCustomer");
		ModelAndView mav = new ModelAndView();
		mav.addObject("addCustomer");
		return mav;
	}
	@RequestMapping("/updateCustomer")
	public ModelAndView updateUser() {
		System.out.println("you are in CustomerController updateCustomer");
		ModelAndView mav = new ModelAndView();
		mav.addObject("updateCustomer");
		return mav;
	}
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteUser() {
		System.out.println("you are in CustomerController updateCustomer");
		ModelAndView mav = new ModelAndView();
		mav.addObject("deleteCustomer");
		return mav;
	}
}
