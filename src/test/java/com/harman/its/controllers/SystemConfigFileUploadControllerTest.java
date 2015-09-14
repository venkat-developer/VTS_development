package com.harman.its.controllers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.servlet.ModelAndView;

public class SystemConfigFileUploadControllerTest {
	
	

	public static void main (String [] args){
//		SystemConfigFileUploadControllerTest systemConfigFileUploadControllerTest = new SystemConfigFileUploadControllerTest();
//		systemConfigFileUploadControllerTest.dateConvertortest();
		
		ModelAndView model = new ModelAndView("error");
		System.out.println(""+model.getViewName());
	}

	private void dateConvertortest() {
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		System.out.println("Date"+dateFormat.format(date));
		Timestamp timestamp=new Timestamp(Calendar.getInstance().getTimeInMillis());
		System.out.println("Timestamp"+timestamp.toString());
	}
}
