package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		System.out.println("you are in Main controller");
		return "home";
	}
}
