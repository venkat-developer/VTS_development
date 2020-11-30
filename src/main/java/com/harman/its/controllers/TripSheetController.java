package com.harman.its.controllers;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.DriverDaoImpl;
import com.harman.its.dao.impl.PassangerDaoImpl;
import com.harman.its.dao.impl.TripSheetDaoImp;
import com.harman.its.dao.impl.VehicleDaoImpl;
import com.harman.its.entity.Driver;
import com.harman.its.entity.LongPrimaryKey;
import com.harman.its.entity.Passenger;
import com.harman.its.entity.TripSheet;
import com.harman.its.entity.UserEntity;
import com.harman.its.entity.Vehicle;
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
	
	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) throws ClassNotFoundException, SQLException, ParseException{
		ModelAndView model = new ModelAndView("tripsheet");
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		List<TripSheet> liveFinalResult = null;
		
		String action = request.getParameter("action");
		
		if(null != action && action.equalsIgnoreCase("add")) {
			TripSheet tripEntity = new TripSheet();
			TripSheetDaoImp tripSheetDao = new TripSheetDaoImp();
			tripEntity.setTripSheetNumber(Long.parseLong(request.getParameter("tripId")));
			tripEntity.setPassangerName(request.getParameter("paxName"));
			tripEntity.setRefferedBy(request.getParameter("referredBy"));
			tripEntity.setTripType(Integer.parseInt(request.getParameter("tripType")));
			tripEntity.setVehicleType(Integer.parseInt(request.getParameter("vehicleType")));
			tripEntity.setVehicleId(Long.parseLong(request.getParameter("vehicleId")));
			tripEntity.setDriverId(Long.parseLong(request.getParameter("driverId")));
			tripEntity.setACTrip(Boolean.valueOf(request.getParameter("tripType")));
			tripEntity.setUserID(user.getId());
			System.out.println("start date "+request.getParameter("startDate"));
			System.out.println("End date "+request.getParameter("endDate"));
			System.out.println(tripEntity.toString());
			//tripSheetDao.insert(tripEntity);
		}else {
			VehicleDaoImpl vehicleDao = new VehicleDaoImpl();
			List<Vehicle> vehicleList = vehicleDao.selectAllByUserID(user.getId());
			model.addObject("vehicleList", vehicleList);
			
			DriverDaoImpl driverDao = new DriverDaoImpl();
			List<Driver> driverList = driverDao.selectAllByUserID(user.getId());
			model.addObject("driverList", driverList);
			
			PassangerDaoImpl passangerDao = new PassangerDaoImpl();
			List<Passenger> passangerList = passangerDao.selectAllByUserID(user.getId());
			model.addObject("passangerList", passangerList);
		}
	
		return model.addObject("tripDeatils", liveFinalResult);
	}
}