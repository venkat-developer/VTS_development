package com.harman.its.utils;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {

	private org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(ApplicationContextListener.class);
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("Context servlet Initialized");
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("Context servlet  Destroyed");
	}
}
