package com.harman.its.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.LiveVehicleStatusDaoImpl;
import com.harman.its.entity.LiveVehicleStatus;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.SessionUtils;

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
		LiveVehicleStatusDaoImpl liveVehicleStatusDaoImpl = new LiveVehicleStatusDaoImpl();
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		logger.debug("User Id is "+user.getId());
		LiveVehicleStatus countOfVehicles = liveVehicleStatusDaoImpl.getVehicleStatusCount(user.getId());
		model.addObject("countOfVehicles", countOfVehicles);
		return model;
	}
}