package com.harman.its.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.VendorDaoImpl;
import com.harman.its.entity.UserEntity;
import com.harman.its.entity.Vendor;
import com.harman.its.utils.SessionUtils;

/**
 * Controller for vendor page View : "Vendor"
 * 
 * @author VAmukapati
 *
 */
public class VendorController extends SimpleFormController {
	Logger logger = Logger.getLogger(VendorController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("vendor");
		logger.debug("Successfully Logged in now you are in VendorController Started at ");
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		logger.debug("User Id is " + user.getId());
		Vendor vendorEntity = new Vendor();
		vendorEntity.setFirstName(request.getParameter("vendorName"));
		try {
			if (null != vendorEntity.getFirstName() && !vendorEntity.getFirstName().isEmpty()) {
				vendorEntity.setUserId(user.getId());
				vendorEntity.setMobileNumber(request.getParameter("vendorPhone"));
				vendorEntity.setAddress(request.getParameter("vendorAddress"));
				vendorEntity.setWebsite(request.getParameter("vendorWebsite"));
				vendorEntity.setEmail(request.getParameter("vendorEmail"));
				vendorEntity.setFaxNumber(request.getParameter("vendorFax"));
				vendorEntity.setLastName("");
				vendorEntity.setContactPerson("");
				VendorDaoImpl vendorDao = new VendorDaoImpl();
				vendorDao.insert(vendorEntity);
			}
		} catch (NullPointerException e) {
			model = new ModelAndView("error");
			model.addObject("errorHeading", "Vendor");
			model.addObject("errorException", "NullPointerException");
			model.addObject("errorMsg", "Returns NULL while insterting vendor data into DB");
			return model;
		} catch (Exception e) {
			logger.error("Error while adding vendor data", e);
			model = new ModelAndView("error");
			model.addObject("errorHeading", "Vendor");
			model.addObject("errorException", "Undefined Exception");
			model.addObject("errorMsg", e.toString());
			return model;
		}
		return model;
	}
}