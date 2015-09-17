package com.harman.its.controllers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.LiveVehicleStatusDaoImpl;
import com.harman.its.entity.LiveVehicleStatus;
import com.harman.its.entity.LiveVehicleStatus.VehicleStatus;
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

		List<LiveVehicleStatus> liveVehicleStatusList = liveVehicleStatusDaoImpl.fetchLiveVehicleStatusOfUser(SessionUtils.getCurrentlyLoggedInUser().getId());
		HashMap<String, Integer> statusCount = new HashMap<String, Integer>();
		for(LiveVehicleStatus liveStatus : liveVehicleStatusList){
			int count = 0;
			VehicleStatus vehicleStatus = getVehicleStatus(liveStatus);
			if(statusCount.get(vehicleStatus.toString()) != null){
				count = statusCount.get(vehicleStatus.toString());
				statusCount.put(vehicleStatus.toString(), ++count);
			} else {
				statusCount.put(vehicleStatus.toString(), ++count);
			}
		}

		int subTotal =0;
		int vehiclesOnlineCount= 0;
		vehiclesOnlineCount = statusCount.get(VehicleStatus.ONLINE.toString()) == null ? 0 : statusCount.get(VehicleStatus.ONLINE.toString());


		int offroadCount = statusCount.get(VehicleStatus.OFFROAD.toString()) == null ? 0 
				: statusCount.get(VehicleStatus.OFFROAD.toString()); 

		int offlinecDCCount = statusCount.get(VehicleStatus.OFFLINE_CHARGER_DISCONNECTED.toString()) == null ? 0 
				: statusCount.get(VehicleStatus.OFFLINE_CHARGER_DISCONNECTED.toString());

		int offlineLowGpsCount = statusCount.get(VehicleStatus.OFFLINE_LOW_GPS.toString()) == null ? 0 
				: statusCount.get(VehicleStatus.OFFLINE_LOW_GPS.toString());

		int offlineLowGsmCount = statusCount.get(VehicleStatus.OFFLINE_LOW_GSM.toString()) == null ? 0
				: statusCount.get(VehicleStatus.OFFLINE_LOW_GSM.toString());

		int offlineCount = statusCount.get(VehicleStatus.OFFLINE.toString()) == null ? 0 
				: statusCount.get(VehicleStatus.OFFLINE.toString());


		/*User loggedInUser = LoadUserDetails.getInstance().retrieve(SessionUtils.getCurrentlyLoggedInUser().getId());

		if(offlineCount > loggedInUser.getOffroadCount()){
			logger.info("Offroad Count from the DB for the user : "+loggedInUser.getLogin()
					+" is : "+loggedInUser.getOffroadCount());
			offlineCount -= loggedInUser.getOffroadCount();
			offroadCount += loggedInUser.getOffroadCount();
		}
		int noGPRSCount = loggedInUser.getNoGPRSCount();
		if(offlineCount > noGPRSCount){
			logger.info("NoGPRS Count from the DB for the user : "+loggedInUser.getLogin()
					+" is : "+loggedInUser.getNoGPRSCount());
			offlineCount -= noGPRSCount;
			subTotal = (vehiclesOnlineCount+offroadCount+offlinecDCCount+offlineLowGpsCount+offlineLowGsmCount+noGPRSCount);
			model.addObject("vehiclesnogprscount", noGPRSCount);
		} else {
			subTotal = (vehiclesOnlineCount+offroadCount+offlinecDCCount+offlineLowGpsCount+offlineLowGsmCount);
			model.addObject("vehiclesnogprscount", 0);
		}*/


		int grandTotal = (subTotal+offlineCount);

		logger.info("Sub total is "+subTotal);
		model.addObject("vehiclesonlinecount",vehiclesOnlineCount);
		model.addObject("vehiclesoffroadcount",  offroadCount);
		model.addObject("vehiclesofflinecdccount", offlinecDCCount);
		model.addObject("vehiclesofflinelowgpscount",  offlineLowGpsCount);
		model.addObject("vehiclesofflinelowgsmcount", offlineLowGsmCount);
		model.addObject("subTotal", subTotal);
		model.addObject("grandTotal", grandTotal);
		model.addObject("vehiclesofflinecount", offlineCount);
		return model;
	}
	private VehicleStatus getVehicleStatus(LiveVehicleStatus liveVehicleStatus) {
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
		}
		return statusOfVehicle;
	}
}