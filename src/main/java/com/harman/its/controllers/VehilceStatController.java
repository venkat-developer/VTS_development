package com.harman.its.controllers;



import java.sql.SQLException;

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
public class VehilceStatController extends SimpleFormController {

	Logger logger = Logger.getLogger(VehilceStatController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) throws ClassNotFoundException, SQLException{
		ModelAndView model = new ModelAndView("stasticsReport");
		String fromDate=request.getParameter("from");
		String toDate=request.getParameter("to");
		String fromHrs=request.getParameter("fhrs");
		String fromMin=request.getParameter("fmin");
		String fromSec=request.getParameter("fsec");
		String toHrs=request.getParameter("thrs");
		String toMin=request.getParameter("tmin");
		String toSec=request.getParameter("tsec");
		String startDate = fromDate+" "+fromHrs+":"+fromMin+":"+fromSec;
		String toStart = toDate+" "+toHrs+":"+toMin+":"+toSec;
		logger.debug("Start Date : "+startDate+" , End Date : "+toStart);
		
		String vehicleIdString =request.getParameter("vehicleId");
		logger.debug("Vehicle Id is "+vehicleIdString);
		if(vehicleIdString!=null){
			
		}
		return model;
	}
}