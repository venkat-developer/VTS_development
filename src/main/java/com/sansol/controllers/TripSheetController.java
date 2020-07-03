package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TripSheetController {
	@RequestMapping("/tripSheet")
	public String login() {
		System.out.println("you are in TripSheetController");
		return "tripSheet";
	}
}
