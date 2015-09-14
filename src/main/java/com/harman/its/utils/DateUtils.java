package com.harman.its.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private final static String HITS_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String convertJavaDateToSQLDate(Date date){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	public static String convertJavaDateToUIDate(Date date){
		return new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss a").format(date);
	}

	public static String getHitsDateFormat() {
		return HITS_DATE_FORMAT;
	}

	/**
	 * 
	 * @param date
	 * @return
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTimeString(Date date){
		if(date == null){
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @param date
	 * @return
	 * yyyy-MM-dd
	 */
	public static String getDateString(Date date){
		if(date == null){
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @param date
	 * @return
	 * EEE
	 */
	public static String getDayString(Date date){
		if(date == null){
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("EEE");
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @param date
	 * @return
	 * 
	 * HH:mm:ss
	 */
	public static String getTimeString(Date date){
		if(date == null){
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}
}
