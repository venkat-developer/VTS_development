package com.harman.its.controllers;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;

import com.harman.its.dao.impl.LogsDaoImpl;
import com.harman.its.entity.LogsEntity;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.Constants.SESSION;
import com.harman.its.utils.SessionUtils;

/**
 * <b>Manages the login redirection wrt the user types of the project</b>
 * <ul>User types
 * 
 * <li>Owner</li>
 * <li>Operator</li>
 * <li>Admin</li>
 * <li>Passkey</li>
 * </ul>
 * @author VAmukapati
 *
 */

public class RegisterController extends SimpleFormController {

	private Logger logger = Logger.getLogger(RegisterController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) {
		ModelAndView model=new ModelAndView("login");
		return model;
	}

	/**
	 * This method manages log out result  
	 * @param request
	 * @return true if Logout successful, false if its not a logout request
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private boolean isLogOut(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String isLogOut = request.getParameter("isSignOut");
		if(isLogOut != null){
			if(isLogOut.equalsIgnoreCase("true")){
				String type="Logged out";
				logLoginDeatils(request, type);
				WebUtils.setSessionAttribute(request, SESSION.USER_OBJECT, null);
				return true;
			}
		}
		return false;
	}
	/**
	 * Logging in the current logged in details. 
	 * @param request
	 * @param type
	 * @throws SQLException 
	 */
	public void logLoginDeatils(HttpServletRequest request,String type ) throws ClassNotFoundException, SQLException{
		UserEntity currentUser = SessionUtils.getCurrentlyLoggedInUser();
		String remoteip=request.getRemoteAddr();
		Calendar cal = Calendar.getInstance();
		Date currentdate = cal.getTime();
		logger.debug("Current Logged in User is "+currentUser);
		Long userid =0L;
		if(currentUser!=null){
			userid = currentUser.getId();
			logger.debug("Current logged in userId  "+userid);
		}
		String action = currentUser.getFirstname().toUpperCase() +""+ " HAS "+type.toUpperCase();
		LogsEntity logEntity = new LogsEntity(userid,currentdate,remoteip,action);
		LogsDaoImpl log=new LogsDaoImpl();
		// Insertion of user login information to the logs table
		log.insert(logEntity);
	}
}