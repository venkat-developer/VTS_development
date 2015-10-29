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
import com.harman.its.dao.impl.VehicleDaoImpl;
import com.harman.its.entity.TrackHistoryEntity;
import com.harman.its.entity.Vehicle;
import com.harman.its.utils.SessionUtils;



/**
 * Controller for Home page
 * View : "home"
 *  
 * @author VAmukapati
 *
 */
public class MapReportController extends SimpleFormController {

	Logger logger = Logger.getLogger(MapReportController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) throws ClassNotFoundException, SQLException, ParseException{
		ModelAndView model = new ModelAndView("mapReport");
		String fromDate=request.getParameter("from");
		String toDate=request.getParameter("to");
		String fromHrs=request.getParameter("fhrs");
		String fromMin=request.getParameter("fmin");
		String fromSec=request.getParameter("fsec");
		String toHrs=request.getParameter("thrs");
		String toMin=request.getParameter("tmin");
		String toSec=request.getParameter("tsec");
		String startDateString = fromDate+" "+fromHrs+":"+fromMin+":"+fromSec;
		String endDateString = toDate+" "+toHrs+":"+toMin+":"+toSec;
		logger.debug("Start Date : "+startDateString+" , End Date : "+endDateString);

		String vehicleIdString =request.getParameter("vehicleId");
		logger.debug("Vehicle Id is "+vehicleIdString);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(vehicleIdString!=null){
			logger.debug("vehicleIdString is not null hence generate report for selected data ");
			long vehicleId = Long.parseLong(vehicleIdString); 
			VehicleDaoImpl vehicleDaoImpl = new VehicleDaoImpl();
			List<Vehicle> vehiclesList = vehicleDaoImpl.selectByUserId(SessionUtils.getCurrentlyLoggedInUser().getId());
			if(vehiclesList.size()!=0){
				model.addObject("vehiclesList", vehiclesList);	
			}
			
			Date startDate = simpleDateFormat.parse(startDateString);

			Date endDate = simpleDateFormat.parse(endDateString);
			
			List<TrackHistoryEntity> trackData = new TrackHistoryDaoImpl().selectBetweenDates(vehicleId, startDate, endDate);
			if(trackData.size()!=0){
				//logger.debug("You are adding some data here ....");
				model.addObject("trackData", trackData);	
			}	
		}else{
			logger.debug("vehicleIdString is ");
			List<TrackHistoryEntity> trackData =new ArrayList<TrackHistoryEntity>();
			model.addObject("trackData", trackData);
		}
		model.addObject("reportType", "track");
		
		return model;
	}
}