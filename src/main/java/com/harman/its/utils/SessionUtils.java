
package com.harman.its.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.harman.its.entity.UserEntity;


/**
 * Class for handling all session Attributes.
 * @author VAmukapati
 *
 */
public class SessionUtils {
	static Logger logger = Logger.getLogger(SessionUtils.class);
	/**
	 * Get the current logged in User Entity from the HttpRequest.
	 * @return
	 */
	public static UserEntity getCurrentlyLoggedInUser() {
		UserEntity loggedinUser = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		loggedinUser = (UserEntity)WebUtils.getSessionAttribute(request, Constants.SESSION.USER_OBJECT);		
		return loggedinUser;
	}
	public static HttpSession GetCurrentSession(){
		HttpSession session;
		HttpServletRequest req=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		session=req.getSession();
		return session;
	}
	public static String getRemoteip(){
		HttpServletRequest req=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String remoteIp=req.getRemoteAddr();
		return remoteIp;
	}
	/**
	 * Returning user details i.e User name,role is returning back to the View for
	 * For limiting the access based on the User role.
	 * In future Can be added Last logged in time.
	 * @param model
	 */
	public static void addUserDeatils(ModelAndView model) {
		model.addObject("userName",SessionUtils.getCurrentlyLoggedInUser().getFirstName());
		model.addObject("userRole",SessionUtils.getCurrentlyLoggedInUser().getRole());
	}
}

