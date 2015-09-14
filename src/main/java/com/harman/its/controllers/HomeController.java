package com.harman.its.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller for Home page
 * View : "home"
 *  
 * @author VAmukapati
 *
 */
public class HomeController extends SimpleFormController {
	Logger logger = Logger.getLogger(HomeController.class);
	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model = new ModelAndView("home");
		logger.debug("Successfully Logged in now you are in Home Controller");
		return model;
	}
}