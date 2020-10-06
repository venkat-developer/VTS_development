package com.harman.its.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.PassangerDaoImpl;
import com.harman.its.entity.Passenger;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.SessionUtils;

/**
 * Controller for Passenger page View : "passenger"
 * 
 * @author VAmukapati
 *
 */
public class PassengerController extends SimpleFormController {
	Logger logger = Logger.getLogger(PassengerController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("passenger");
		logger.debug("Successfully Logged in now you are in PassengerController Started at ");
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		logger.debug("User Id is " + user.getId());
		Passenger paxEntity = new Passenger();
		paxEntity.setFirstName(request.getParameter("paxFirstName"));
		logger.debug("Passanger first name is "+request.getParameter("paxTitle") + paxEntity.getFirstName());
		try {
			if (null != paxEntity.getFirstName() && !paxEntity.getFirstName().isEmpty()) {
				paxEntity.setUserId(user.getId());
				paxEntity.setFirstName((request.getParameter("paxTitle") + paxEntity.getFirstName()));
				paxEntity.setLastName(request.getParameter("paxLastName"));
				paxEntity.setEmail(request.getParameter("paxEmail"));
				paxEntity.setMobile(request.getParameter("paxMobileNumber"));
				paxEntity.setAddress(request.getParameter("address"));
				paxEntity.setPassengerType(Integer.parseInt(request.getParameter("passengerType")));
				PassangerDaoImpl paxDao = new PassangerDaoImpl();
				paxDao.insert(paxEntity);
			}
		} catch (NullPointerException e) {
			model = new ModelAndView("error");
			model.addObject("errorHeading", "Passanger");
			model.addObject("errorException", "NullPointerException");
			model.addObject("errorMsg", "Returns NULL while insterting passanger data into DB");
			return model;
		} catch (Exception e) {
			logger.error("Error while adding passanger data", e);
			model = new ModelAndView("error");
			model.addObject("errorHeading", "Passanger");
			model.addObject("errorException", "Undefined Exception");
			model.addObject("errorMsg", e.toString());
			return model;
		}
		return model;
	}
}