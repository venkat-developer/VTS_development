package com.harman.its.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

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
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		logger.debug("User Id is "+user.getId());
		return model;
	}
	/*private VehicleStatus getVehicleStatus(LiveVehicleStatus liveVehicleStatus) {
		VehicleStatus statusOfVehicle = VehicleStatus.OFFROAD;
		if (liveVehicleStatus == null) {
			logger.error("LVOS is neither in cache nor in db");			
			return statusOfVehicle;
		}
		if(liveVehicleStatus.isOffroad()){
			logger.debug("Vehicle with trip id : "+liveVehicleStatus.getTripId().getId()+" is Offroad");
			return statusOfVehicle;
		}
		long lastupdatedDay = liveVehicleStatus.getLastUpdatedAt().getTime();
		long moduleUpdateTime = liveVehicleStatus.getModuleUpdateTime().getTime();
		Calendar cal = Calendar.getInstance();
		long currDate = cal.getTimeInMillis(); 
		long lastUpdatediff =	currDate-lastupdatedDay; 
		long moduleUpdatediff =	currDate-moduleUpdateTime; 
		double lastUpdatedDiffDays = lastUpdatediff/(24*60*60*1000);
		double moduleUpdatediffDay = moduleUpdatediff/(24*60*60*1000);
		//to prevent negative values
		if(lastUpdatedDiffDays < 1 || moduleUpdatediffDay < 1){
			lastUpdatedDiffDays = -(lastUpdatedDiffDays);
			moduleUpdatediffDay = -(moduleUpdatediffDay);
		}
		if( liveVehicleStatus.isIdle() && (lastUpdatedDiffDays == 0 || moduleUpdatediffDay ==0)){
			// IDLE vehicle counted in ONLINE status 
			statusOfVehicle = VehicleStatus.ONLINE;
		} else if( lastUpdatedDiffDays > 0 && moduleUpdatediffDay > 0 ) { 
			statusOfVehicle = VehicleStatus.OFFLINE; 

			if(!liveVehicleStatus.isChargerConnected()){
				statusOfVehicle = VehicleStatus.OFFLINE_CHARGER_DISCONNECTED;
			} else if(liveVehicleStatus.getGsmStrength() < 18){
				statusOfVehicle = VehicleStatus.OFFLINE_LOW_GSM;
			} else if(liveVehicleStatus.getGpsStrength() > 1){					//<= 0.5 || liveVehicleStatus.getGpsStrength() >= 1.5){
				statusOfVehicle = VehicleStatus.OFFLINE_LOW_GPS;
			}

		} else {
			statusOfVehicle = VehicleStatus.ONLINE;
		}*/
		//return statusOfVehicle;
	//}
}