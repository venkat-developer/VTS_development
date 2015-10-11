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
import com.harman.its.dao.impl.DriverDaoImpl;
import com.harman.its.dao.impl.LiveVehicleStatusDaoImpl;
import com.harman.its.dao.impl.TripDaoImp;
import com.harman.its.dao.impl.VehicleDaoImpl;
import com.harman.its.entity.LiveVehicleStatus;
import com.harman.its.entity.TripDeatils;
import com.harman.its.entity.TripsEntity;
import com.harman.its.entity.UserEntity;
import com.harman.its.entity.Vehicle;
import com.harman.its.utils.SessionUtils;

/**
 * Controller for Home page
 * View : "home"
 * @author VAmukapati
*/

public class LiveDatController extends SimpleFormController {
	Logger logger = Logger.getLogger(LiveDatController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model = new ModelAndView("liveData");
		List<TripDeatils> liveFinalResult = null;
		try {
			logger.debug("Successfully Logged in now you are in Home Controller Started at "+new Date());
			UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
			logger.debug("User Id is "+user.getId());
			TripDaoImp tripDao = new TripDaoImp();
			List<TripsEntity> tripsList = tripDao.selectTripsByUserId(user.getId());
			LiveVehicleStatusDaoImpl liveDaoImpl = new LiveVehicleStatusDaoImpl();
			liveFinalResult = new ArrayList<TripDeatils>();
			logger.debug("No.Of trips of this user is "+tripsList.size());
			VehicleDaoImpl vehicleDaoImpl = new VehicleDaoImpl();
			DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
			Vehicle vehicle =  new Vehicle();
			for(TripsEntity tripDetails : tripsList){
				logger.debug("You are in for loop of trip deatils ");
				LiveVehicleStatus liveData = liveDaoImpl.getLiveDataByTripId(tripDetails.getId().getId());
				TripDeatils trip = new TripDeatils();
				if(liveData!=null){
					trip.setVehicleName(vehicleDaoImpl.selectByVehicleId(liveData.getVehicleId()).getDisplayName());
					trip.setDriverName(driverDaoImpl.selectByDriverId(liveData.getDriverId()).getDisplayName());
					trip.setCummalativeDistance(liveData.getCumulativeDistance());
					trip.setImei(liveData.getImei());
					trip.setBatteryVolatge(liveData.getBatteryVoltage());
					trip.setDirection(liveData.getCourse());
					trip.setLatitude(liveData.getLocation().getFirstPoint().getY());
					trip.setLongitude(liveData.getLocation().getFirstPoint().getX());
					logger.debug("Latitude is "+trip.getLatitude()+" , Longitude is "+trip.getLongitude());
					trip.setChargerConnected(liveData.isChargerConnected());
					trip.setGpsStrength(liveData.getGpsStrength());
					trip.setGsmStrength(liveData.getGsmStrength());
					trip.setSpeed(liveData.getMaxSpeed());
					trip.setUpdatedatedTime(liveData.getLastUpdatedAt());
					String statusofVeh = vehicle.getStatus(vehicle.getImei(),liveData,tripDetails);
					trip.setVhehicleStatus(statusofVeh);
					liveFinalResult.add(trip);
				}
			} 
			logger.info("Ended at "+new Date());
			Object obj = liveFinalResult.toArray();
			
			logger.debug("Data to array is ..... "+obj);
			model.addObject("liveFinalResult",liveFinalResult);
			model.addObject("tripDeatils",obj);
			return model;//model.addObject("tripDeatilsOmData",om);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model.addObject("tripDeatils", liveFinalResult);
	}
}