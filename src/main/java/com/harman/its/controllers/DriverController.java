package com.harman.its.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.DriverDaoImpl;
import com.harman.its.entity.Driver;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.SessionUtils;

/**
 * Controller for driver page View : "driver"
 * 
 * @author VAmukapati
 *
 */
public class DriverController extends SimpleFormController {
	Logger logger = Logger.getLogger(DriverController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("driver");
		logger.debug("Successfully Logged in now you are in DriverController");
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		Driver driverEntity = new Driver();
		driverEntity.setFirstName(request.getParameter("driverFirstName"));;
		logger.debug("Driver first name is " + driverEntity.getFirstName());
		try {
			if (null !=driverEntity.getFirstName() && !driverEntity.getFirstName().isEmpty()) {
				driverEntity.setLastName(request.getParameter("driverLastName"));
				driverEntity.setLicenseNo(request.getParameter("licenceNo"));
				driverEntity.setMobileNumber(request.getParameter("driverMobileNo"));
				driverEntity.setEmail(request.getParameter("driverEmail"));
				driverEntity.setUserId(user.getId());
				DriverDaoImpl driverDao = new DriverDaoImpl();
				driverDao.insert(driverEntity);
			}
		} catch (NullPointerException e) {
			model = new ModelAndView("error");
			model.addObject("errorHeading", "Driver");
			model.addObject("errorException", "NullPointerException");
			model.addObject("errorMsg", "Returns NULL while insterting driver data into DB");
			return model;
		} catch (Exception e) {
			logger.error("Error while adding driver data", e);
			model = new ModelAndView("error");
			model.addObject("errorHeading", "Driver");
			model.addObject("errorException", "Undefined Exception");
			model.addObject("errorMsg", e.toString());
			return model;
		}
		return model;
	}
}