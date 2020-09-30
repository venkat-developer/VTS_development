package com.harman.its.controllers;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import com.harman.its.dao.impl.LogsDaoImpl;
import com.harman.its.dao.impl.UserDaoImpl;
import com.harman.its.entity.LogsEntity;
import com.harman.its.entity.UserEntity;
import com.harman.its.entity.UserEntity.UserRole;
import com.harman.its.utils.Constants;
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

public class LoginController extends SimpleFormController {

	private Logger logger = Logger.getLogger(LoginController.class);

	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response) {
		ModelAndView model=new ModelAndView("login");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type="Logged in";
		try{
			if(isLogOut(request)){
				return model;
			}
			if(userName == null || password == null){
				model= new ModelAndView("login");
				return model;
			}
			UserDaoImpl userDao = new UserDaoImpl();
			UserEntity userEntity = userDao.authenticateUser(userName,password);
			if(null !=userEntity) {
				logger.debug("User name : "+userEntity.getLogin()+" , role is "+userEntity.getRole());
				if(userEntity.getRole()==UserRole.NORMAL_USER){
					/**
					 * User Logged in success redirecting to home page.
					 */
					model = new ModelAndView(new RedirectView(getSuccessView()));
					WebUtils.setSessionAttribute(request, Constants.SESSION.USER_OBJECT, userEntity);
					logLoginDeatils(request, type);
				}else if (userEntity.getRole()==UserRole.ADMIN_USER) {
					model = new ModelAndView("controlpanel");
					WebUtils.setSessionAttribute(request, Constants.SESSION.USER_OBJECT, userEntity);
					logLoginDeatils(request, type);
				}else if (userEntity.getRole()==UserRole.SUPER_USER) {
					model = new ModelAndView("register");
					WebUtils.setSessionAttribute(request, Constants.SESSION.USER_OBJECT, userEntity);
					logLoginDeatils(request, type);
				}	
			}else{
				model=new ModelAndView("login");
				model.addObject("msg", "Invalid Username or Password");
			}
		}catch (NullPointerException e) {
			logger.error("Error while logging the requests ",e);
			model=new ModelAndView("error");
			model.addObject("errorHeading","Login");
			model.addObject("errorException","NullPointerException");
			model.addObject("errorMsg", "Returns NULL while retriving user credentials from DB");
			return model;
		}catch(Exception e){
			logger.error("Error while logging the requests ",e);
			model=new ModelAndView("error");
			model.addObject("errorHeading","Login");
			model.addObject("errorException","Undefined Exception");
			model.addObject("errorMsg", e.toString());
			return model;
		}
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
		String action = currentUser.getFirstName().toUpperCase() +""+ " HAS "+type.toUpperCase();
		LogsEntity logEntity = new LogsEntity(userid,currentdate,remoteip,action);
		LogsDaoImpl log=new LogsDaoImpl();
		// Insertion of user login information to the logs table
		log.insert(logEntity);
	}
}