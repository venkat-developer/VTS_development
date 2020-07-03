package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping("/users")
	public String userController() {
		System.out.println("you are in UserContrller");
		ModelAndView mav = new ModelAndView();
		mav.addObject("home");
		//There is some problem in returning ModeAndView object hence returning jsp page name.
		return "userControlPanel";
	}
	@RequestMapping("/addUser")
	public ModelAndView addUser() {
		System.out.println("you are in UserContrller add user");
		ModelAndView mav = new ModelAndView();
		mav.addObject("addUser");
		return mav;
	}
	@RequestMapping("/updateUser")
	public ModelAndView updateUser() {
		System.out.println("you are in UserContrller updateUser");
		ModelAndView mav = new ModelAndView();
		mav.addObject("updateUser");
		return mav;
	}
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser() {
		System.out.println("you are in UserContrller deleteUser");
		ModelAndView mav = new ModelAndView();
		mav.addObject("deleteUser");
		return mav;
	}
}
