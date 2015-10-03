package com.harman.its.controllers;



import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.TrackHistoryDaoImpl;
import com.harman.its.dao.impl.TripDaoImp;
import com.harman.its.entity.TrackHistoryEntity;
import com.harman.its.entity.TripsEntity;



/**
 * Controller for Home page
 * View : "home"
 *  
 * @author VAmukapati
 *
 */
public class MapReportController extends SimpleFormController {

	Logger logger = Logger.getLogger(MapReportController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) throws ClassNotFoundException, SQLException{
		ModelAndView model = new ModelAndView("mapReport");
		String fromDate=request.getParameter("from");
		String toDate=request.getParameter("to");
		String fromHrs=request.getParameter("fhrs");
		String fromMin=request.getParameter("fmin");
		String fromSec=request.getParameter("fsec");
		String toHrs=request.getParameter("thrs");
		String toMin=request.getParameter("tmin");
		String toSec=request.getParameter("tsec");
		String startDate = fromDate+" "+fromHrs+":"+fromMin+":"+fromSec;
		String toStart = toDate+" "+toHrs+":"+toMin+":"+toSec;
		logger.debug("Start Date : "+startDate+" , End Date : "+toStart);
		long vehcileId = 7773240;
		//TripDaoImp tripDao = new TripDaoImp();

		//List<TripsEntity> resultset = tripDao.fetchAllTripsByVehicleId(vehcileId);
		List<TrackHistoryEntity> trackData = new TrackHistoryDaoImpl().selectBetweenDates(vehcileId, startDate, toStart);
		/*if (null != resultset) {
			for (int i = 0; i < resultset.size(); i++) {
				TripsEntity trip  = resultset.get(i);
			}
		} */
		//logger.debug("Track Data size is "+trackData.size());
		for(int i =0;i<trackData.size();i++){
			//logger.debug("Track data is values are ::: "+trackData.get(i).toString());	
		}
		
		
		if(trackData.size()!=0){
			//logger.debug("You are adding some data here ....");
			model.addObject("trackData", trackData);	
		}
		
		return model;
	}
}