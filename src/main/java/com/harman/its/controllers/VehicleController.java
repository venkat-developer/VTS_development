package com.harman.its.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.VehicleDaoImpl;
import com.harman.its.entity.UserEntity;
import com.harman.its.entity.Vehicle;
import com.harman.its.utils.SessionUtils;

/**
 * Controller for Vehicle page
 * View : "vehicle"
 *  
 * @author VAmukapati
 *
 */
public class VehicleController extends SimpleFormController {
	Logger logger = Logger.getLogger(VehicleController.class);
	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model = new ModelAndView("vehicle");
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		Vehicle vehicleEntity = new Vehicle();
		vehicleEntity.setRegistrationNo(request.getParameter("registrationNo"));
		try {
		if(null != vehicleEntity.getRegistrationNo() && !vehicleEntity.getRegistrationNo().isEmpty()) {
			vehicleEntity.setUserId(user.getId());
			vehicleEntity.setVehicleMake(request.getParameter("vehicleMake"));
			vehicleEntity.setVehicleModel(request.getParameter("vehicleModel"));
			vehicleEntity.setVehicleType(Integer.parseInt(request.getParameter("vehicleType")));
			//vehicle.setInsuranceValidTill(request.getParameter("insurance"));
			vehicleEntity.setACVehicle(Boolean.parseBoolean(request.getParameter("ac")));
			System.out.println("Reg : "+vehicleEntity.getRegistrationNo()
								+" , userId "+vehicleEntity.getUserId()
								+" , vehicleMake "+vehicleEntity.getVehicleMake()
								+" , vehicleModel "+vehicleEntity.getVehicleModel()
								+" , vehicleType "+vehicleEntity.getVehicleType()
								+" , ac "+vehicleEntity.isACVehicle());
			VehicleDaoImpl vehicleDao = new VehicleDaoImpl();
			vehicleEntity = vehicleDao.insert(vehicleEntity);
			model.addObject("vehicle", vehicleEntity);
		}
	}catch (NullPointerException e) {
			logger.error("Error while logging the requests ",e);
			model=new ModelAndView("error");
			model.addObject("errorHeading","Vehicle");
			model.addObject("errorException","NullPointerException");
			model.addObject("errorMsg", "Returns NULL while insterting vehicle data into DB");
			return model;
		}catch(Exception e){
			logger.error("Error while adding vehicle data",e);
			model=new ModelAndView("error");
			model.addObject("errorHeading","Vehicle");
			model.addObject("errorException","Undefined Exception");
			model.addObject("errorMsg", e.toString());
			return model;
		}
		return model;
	}
}