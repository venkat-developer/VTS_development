package com.harman.its.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.harman.its.dao.impl.LogsDaoImpl;
import com.harman.its.entity.LogsEntity;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.DateUtils;
import com.harman.its.utils.SessionUtils;

/**
 * 
 * @author HDamodaran
 *
 */
public class MainController extends SimpleFormController {
	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model=new ModelAndView("home");
		String requestType=request.getParameter("type");
		if(requestType != null){
			if(requestType.equalsIgnoreCase("Header")){
				model = new ModelAndView("header");
			}else if(requestType.equalsIgnoreCase("SideBar")){
				model=new ModelAndView("sidebar");
			}else if(requestType.equalsIgnoreCase("Footer")){
				model=new ModelAndView("footer");
			}else if(requestType.equalsIgnoreCase("LastLogin")){
				model=new ModelAndView("lastlogin");
				getlastLoggedInDeatils(model);
				SessionUtils.addUserDeatils(model);
			}else if(requestType.equalsIgnoreCase("map")){
				model=new ModelAndView("map");
			}
		}
		return model;
	}
	/**
	 * Add last login details to the view.  
	 * @param model
	 */
	private void getlastLoggedInDeatils(ModelAndView model) {
		UserEntity userEntity = SessionUtils.getCurrentlyLoggedInUser();
		if(userEntity != null){
			LogsDaoImpl logsDao = new LogsDaoImpl();
			List<LogsEntity> logsList = logsDao.selectLastLogin(userEntity.getId());
			LogsEntity lastLog =null;
			String lastLogin = "NO PREIVIOUS LOGIN";
			if(logsList.size() == 2){
				lastLog = logsList.get(1);
			}else{
				lastLog=logsList.get(0);
			}
			if(lastLog != null){
				lastLogin = DateUtils.convertJavaDateToUIDate(lastLog.getRequestedAt());
			}
			model.addObject("lastLogin", lastLogin);
		}
	}
}