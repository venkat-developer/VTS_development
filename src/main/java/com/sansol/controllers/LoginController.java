package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sansol.dao.UserDaoImpl;
import com.sansol.model.Login;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout,
	@RequestParam("username") String username,@RequestParam("password") String password,
	@ModelAttribute("login") Login login) {
		ModelAndView model = new ModelAndView();
		System.out.println("you are in LoginController : "+username +" , password : "+password);
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}

		UserDaoImpl impl = new UserDaoImpl();
		
		impl.validateUser(login);
		
		model.setViewName("home");
		return model;
	}
	
//	public String login(@RequestParam("username") String username,@RequestParam("password") String password) {
//		System.out.println("you are in LoginController : "+username +" , password : "+password);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("home");
//		return "home";
//	}
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
