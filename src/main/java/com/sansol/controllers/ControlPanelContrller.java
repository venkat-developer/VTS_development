package com.sansol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlPanelContrller {
	@RequestMapping("/controlPanel")
	public ModelAndView controlPanel() {
		System.out.println("you are in ControlPanelContrller");
		ModelAndView mav = new ModelAndView();	
		mav.addObject("controlPanel");
		return mav;
	}
}
