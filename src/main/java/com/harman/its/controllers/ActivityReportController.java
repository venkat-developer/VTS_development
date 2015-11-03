package com.harman.its.controllers;



import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.postgis.Geometry;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.TrackHistoryDaoImpl;
import com.harman.its.entity.ActivityReportEntity;
import com.harman.its.entity.TrackHistoryEntity;
import com.harman.its.utils.CustomCoordinates;



/**
 * Controller for Home page
 * View : "home"
 *  
 * @author VAmukapati
 *
 */
public class ActivityReportController extends SimpleFormController {

	Logger logger = Logger.getLogger(ActivityReportController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) throws ClassNotFoundException, SQLException{
		ModelAndView model = new ModelAndView("activityReport");

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
if(timeFilter!=null){
	if(timeFilter.equalsIgnoreCase("today")){
		Date d = new Date();
		startDateString = (d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" 00:00:00";
		endDateString = (d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" 23:59:59";
	}else{
		startDateString = fromDate+" "+fromHrs+":"+fromMin+":"+fromSec;
		endDateString = toDate+" "+toHrs+":"+toMin+":"+toSec;
		logger.debug("Start Date : "+startDateString+" , End Date : "+endDateString);
	}

}
		
		
		String vehicleIdString =request.getParameter("vehicleId");
		logger.debug("Vehicle Id is "+vehicleIdString);
		String intervalString=request.getParameter("interval");
		int interval =0;
		try {
			if(intervalString != null){
				interval = Integer.parseInt(intervalString);	
			}
			if(vehicleIdString!=null){
				long vehicleId = Long.parseLong(vehicleIdString); 
				TrackHistoryDaoImpl trackHistoryDaoImpl = new TrackHistoryDaoImpl();
				List<ActivityReportEntity> acivityReportList = new ArrayList<ActivityReportEntity>();
				List<TrackHistoryEntity> trackHistoryResultset;

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date startDate = simpleDateFormat.parse(startDateString);
				Date endDate = simpleDateFormat.parse(endDateString);

				if(interval != 0 ){
					trackHistoryResultset = trackHistoryDaoImpl.selectBetweenDatesIntervalNotZero(vehicleId, startDate, endDate,interval);
				}else{
					trackHistoryResultset = trackHistoryDaoImpl.selectBetweenDates(vehicleId, startDate,endDate);
				}


				List<TrackHistoryEntity> filteredResultSet = new ArrayList<TrackHistoryEntity>();
				float distance = 0.0F;

				/** If interval is zero we need fetch only first fifteen between the given start and end dated **/
				TrackHistoryEntity prevTrackHistory = null;
				for (int j = 0; j <trackHistoryResultset.size(); j++) {
					Geometry points = trackHistoryResultset.get(j).getLocation();
					if(prevTrackHistory != null){
						Geometry prevPoints = prevTrackHistory.getLocation();
						logger.debug("Lat1, Lng1 : "+prevPoints.getFirstPoint().getY()+", "+prevPoints.getFirstPoint().getX()+
								" Lat2, Lng2 : "+points.getFirstPoint().getY()+", "+points.getFirstPoint().getX());
						float calculatedDistance = (float) CustomCoordinates.distance(prevPoints.getFirstPoint().getY(), prevPoints.getFirstPoint().getX(),
								points.getFirstPoint().getY(), points.getFirstPoint().getX());
						trackHistoryResultset.get(j).setDistance((float)(calculatedDistance + (0.1*calculatedDistance)));
					}
					prevTrackHistory = trackHistoryResultset.get(j);
					logger.debug("Calculated distance : "+trackHistoryResultset.get(j).getDistance());
					distance += trackHistoryResultset.get(j).getDistance();
					logger.debug("Cumulative distance : "+distance);
					trackHistoryResultset.get(j).setDistance(distance);
					filteredResultSet.add(trackHistoryResultset.get(j));
				}
				DecimalFormat df = new DecimalFormat("0.##");
				/** Data Extraction **/
				for (int i=0; i<filteredResultSet.size(); i++) {
					TrackHistoryEntity tHistory = filteredResultSet.get(i);
					ActivityReportEntity report = new ActivityReportEntity();
					report.setLocation(tHistory.getLocation().getFirstPoint().y+":"+tHistory.getLocation().getFirstPoint().x);
					report.setOccurredAt(tHistory.getOccurredat());
					Geometry points = tHistory.getLocation();

					report.setLatitude(points.getFirstPoint().getY());
					report.setLongitude(points.getFirstPoint().getX());
					report.setSpeed(df.format(tHistory.getSpeed()));
					report.setDistance(df.format(tHistory.getDistance()));
					acivityReportList.add(report);
				}
				model.addObject("activityReportList", acivityReportList);
				model.addObject("from", fromDate);
				model.addObject("to", toDate);
				model.addObject("fhrs",fromHrs);
				model.addObject("fmin",fromMin);
				model.addObject("fsec", fromSec);
				model.addObject("thrs", toHrs);
				model.addObject("tmin", toMin);
				model.addObject("tsec",toSec);
				model.addObject("timefilter", timeFilter);
				model.addObject("vehicleId",vehicleIdString);
			}
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("reportType", "activity");
		return model;
	}
}