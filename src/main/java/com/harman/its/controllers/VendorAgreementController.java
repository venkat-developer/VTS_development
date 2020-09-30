package com.harman.its.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.entity.TripDeatils;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.SessionUtils;

/**
 * Controller for Home page
 * View : "home"
 *  
 * @author VAmukapati
 *
 */
public class VendorAgreementController extends SimpleFormController {
	Logger logger = Logger.getLogger(VendorAgreementController.class);
	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model = new ModelAndView("vendorAgreement");
		logger.debug("Successfully Logged in now you are in TripSheetController Started at ");
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		logger.debug("User Id is "+user.getId());
		List<TripDeatils> liveFinalResult = null;
	
		return model.addObject("tripDeatils", liveFinalResult);
	}
}