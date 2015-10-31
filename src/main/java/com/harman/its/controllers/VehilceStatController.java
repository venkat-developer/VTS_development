package com.harman.its.controllers;




import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.TrackHistoryDaoImpl;
import com.harman.its.dao.impl.TripDaoImp;
import com.harman.its.dao.impl.VehicleDaoImpl;
import com.harman.its.entity.TrackHistoryEntity;
import com.harman.its.entity.TripsEntity;
import com.harman.its.entity.Vehicle;
import com.harman.its.entity.VehicleSatsEntity;
import com.harman.its.utils.CustomCoordinates;
import com.harman.its.utils.SessionUtils;



/**
 * Controller for Home page
 * View : "home"
 *  
 * @author VAmukapati
 *
 */
public class VehilceStatController extends SimpleFormController {

	Logger logger = Logger.getLogger(VehilceStatController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) throws ClassNotFoundException, SQLException, ParseException{
		ModelAndView model = new ModelAndView("stasticsReport");
		String fromDate=request.getParameter("from");
		String toDate=request.getParameter("to");
		String fromHrs=request.getParameter("fhrs");
		String fromMin=request.getParameter("fmin");
		String fromSec=request.getParameter("fsec");
		String toHrs=request.getParameter("thrs");
		String toMin=request.getParameter("tmin");
		String toSec=request.getParameter("tsec");
		
		String timeFilter=request.getParameter("timefilter");
		logger.debug("Time filter is "+timeFilter);
		String startDateString  =null;
		String endDateString  = null;
		if(timeFilter.equalsIgnoreCase("today")){
			Date d = new Date();
			startDateString = (d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" 00:00:00";
			endDateString = (d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" 23:59:59";
		}else{
			startDateString = fromDate+" "+fromHrs+":"+fromMin+":"+fromSec;
			endDateString = toDate+" "+toHrs+":"+toMin+":"+toSec;
		}
		logger.debug("Start Date : "+startDateString+" , End Date : "+endDateString);

		String vehicleIdString =request.getParameter("vehicleId");
		logger.debug("Vehicle Id is "+vehicleIdString);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		if(vehicleIdString!=null){
			Date startDate = simpleDateFormat.parse(startDateString);
			Date endDate = simpleDateFormat.parse(endDateString);

			List<VehicleSatsEntity> statsEntityList = new ArrayList<VehicleSatsEntity>();
			TrackHistoryDaoImpl trackHistoryDaoImpl = new TrackHistoryDaoImpl();
			long userId = SessionUtils.getCurrentlyLoggedInUser().getId();
			TripDaoImp tripDaoImp = new TripDaoImp();
			VehicleDaoImpl vehicleDaoImpl = new VehicleDaoImpl();
			List<TripsEntity> tripList = tripDaoImp.selectTripsByUserId(userId);
			logger.debug("No.of trips for this is user is ::: "+tripList.size());
			for (int i = 0; i < tripList.size(); i++) {
				VehicleSatsEntity status = new VehicleSatsEntity();
				TripsEntity tripsEntity = tripList.get(i);
				Vehicle vehicle  = vehicleDaoImpl.selectByVehicleId(tripsEntity.getVehicleId());
				logger.debug("Vehilce Id is "+vehicle.getId().getId());
				long vehicleId=vehicle.getId().getId();

				status.setVehicleId(vehicleId);
				status.setVehicleName(vehicle.getDisplayName());

				List<TrackHistoryEntity> trackEntries = trackHistoryDaoImpl.selectBetweenDates(vehicleId, startDate, endDate);

				VehicleSatsEntity statisticsResult = trackHistoryDaoImpl.getAvgAndMaxSpeedAndCumulativeDistanceForVehicle(vehicleId, startDate, endDate);
				if (statisticsResult!=null && trackEntries.size() != 0){

					// This function will return the start location of the vehicle from the track history table
					TrackHistoryEntity firstTrackPoint = trackEntries.get(0);//vehiclestartlocation.get(0);
					double a = firstTrackPoint.getLocation().getFirstPoint().getY();
					double b = firstTrackPoint.getLocation().getFirstPoint().getX();
					status.setStartLatitude(a);
					status.setStartLongitude(b);
					StringBuffer startlocation= new StringBuffer();
					startlocation.append(a+":"+b);
					logger.debug("Start Location Latitude "+a+" Longitude "+b);
					TrackHistoryEntity lastTrackPoint = trackEntries.get(trackEntries.size()-1);//tracklist.get(0);
					double x = lastTrackPoint.getLocation().getFirstPoint().getY();
					double y = lastTrackPoint.getLocation().getFirstPoint().getX();
					status.setEndLatitude(a);
					status.setEndLongitude(b);
					logger.debug("End Location Location Latitude "+x+" Longitude "+y);
					StringBuffer endLoaction=new StringBuffer();

					endLoaction.append(x+":"+y);
					String idleDuration=" ";
					status.setStartTime(firstTrackPoint.getOccurredat());
					status.setEndTime(lastTrackPoint.getOccurredat());

					status.setStartLocation(startlocation.toString());
					status.setEndLocation(endLoaction.toString());
					status.setChargerConnected(lastTrackPoint.isChargerConnected());
					status.setSpeed(statisticsResult.getSpeed());
					status.setAvgspeed(statisticsResult.getAvgspeed());
					status.setIdleDuration(idleDuration);
					float distance = 0;
					TrackHistoryEntity prevTrackHistory = null;
					for(TrackHistoryEntity trackEntry : trackEntries){
						if(prevTrackHistory != null){
							float airDistance = (float) CustomCoordinates.distance(prevTrackHistory.getLocation().getFirstPoint().getY(), 
									prevTrackHistory.getLocation().getFirstPoint().getX(),
									trackEntry.getLocation().getFirstPoint().getY(), trackEntry.getLocation().getFirstPoint().getX());
							distance += (airDistance + (0.1 * airDistance));
						}
						prevTrackHistory = trackEntry;
					}
					status.setDistance(distance);
				}
				statsEntityList.add(status);
			}
			model.addObject("from", startDateString);
			model.addObject("to", endDateString);
			model.addObject("vehicleStatsList", statsEntityList);
			model.addObject("reportType", "stats");
		}
		return model;
	}
}