package com.harman.its.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.LiveVehicleStatusDaoImpl;
import com.harman.its.dao.impl.TripDaoImp;
import com.harman.its.entity.LiveVehicleStatus;
import com.harman.its.entity.TripDeatils;
import com.harman.its.entity.TripsEntity;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.SessionUtils;

/**
 * Controller for Home page
 * View : "home"
 *  
 * @author VAmukapati
 *
 */
public class TripSheetController extends SimpleFormController {
	Logger logger = Logger.getLogger(TripSheetController.class);
	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model = new ModelAndView("tripsheet");
		logger.debug("Successfully Logged in now you are in TripSheetController Started at ");
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		logger.debug("User Id is "+user.getId());
		List<TripDeatils> liveFinalResult = null;
		/*try {
			TripDaoImp tripDao = new TripDaoImp();
			List<TripsEntity> tripsList = tripDao.selectTripsByUserId(user.getId());
			LiveVehicleStatusDaoImpl liveDaoImpl = new LiveVehicleStatusDaoImpl();
			liveFinalResult = new ArrayList<TripDeatils>();
			logger.debug("No.Of trips of this user is "+tripsList.size());
			for(TripsEntity tripDetails : tripsList){
				logger.debug("You are in for loop of trip deatils ");
				LiveVehicleStatus liveData = liveDaoImpl.getLiveDataByTripId(tripDetails.getId().getId());
				TripDeatils trip = new TripDeatils();
				if(liveData!=null){
					trip.setVehicleName("Vehicle Name ");
					trip.setDriverName("Driver Name");
					trip.setLocation("Bengaluru,Karnataka,India");
					trip.setCummalativeDistance(liveData.getCumulativeDistance());
					trip.setImei(liveData.getImei());
					trip.setBatteryVolatge(liveData.getBatteryVoltage());
					trip.setDirection(liveData.getCourse());
					trip.setLatitude(liveData.getLocation().getFirstPoint().getX());
					trip.setLatitude(liveData.getLocation().getFirstPoint().getY());
					trip.setChargerConnected(liveData.isChargerConnected());
					trip.setGpsStrength(liveData.getGpsStrength());
					trip.setGsmStrength(liveData.getGsmStrength());
					trip.setSpeed(liveData.getMaxSpeed());
					trip.setUpdatedatedTime(liveData.getLastUpdatedAt());
					trip.setVhehicleStatus("Online");
					liveFinalResult.add(trip);
				}
			} 
			logger.info("Ended at "+new Date());
			return model.addObject("tripDeatils",liveFinalResult);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return model.addObject("tripDeatils", liveFinalResult);
	}
}