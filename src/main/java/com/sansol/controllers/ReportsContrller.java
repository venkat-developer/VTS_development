package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportsContrller {
	@RequestMapping("/reports")
	public String reports() {
		System.out.println("you are in ReportsContrller");
		return "reportsHome";
	}
}
