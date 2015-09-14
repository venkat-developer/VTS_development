/*package com.harman.its.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.harman.its.entity.IncrementerEntity;



public class CsvFileCreation {

	Logger logger = Logger.getLogger(CsvFileCreation.class);

	private int fileIncrementer ;
	private String fileCategory;
	private String deviceId;
	private String deviceType;
	private String currentDate;
	private String fileStore;
	private String fileLocation;
	private String fileExt;

	public String getFileLocation() {
		return fileLocation;
	}


	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}


	public String getFileStore() {
		return fileStore;
	}


	public void setFileStore(String fileStore) {
		this.fileStore = fileStore;
	}

	IncrementerEntity fileIncrementerObject;

	public CsvFileCreation(String fileCategory,String deviceId,String deviceType,String fileLocation,String fileStore,String fileExt){
		this.fileCategory=fileCategory;
		this.deviceId=deviceId;
		this.deviceType=deviceType;
		fileIncrementer=getFileIncrementer(fileCategory);
		currentDate=getCurrentDate();
		this.fileLocation=fileLocation;
		this.fileStore=fileStore;
		this.fileExt=fileExt;
	}


	*//**\
	 * 
	 * @param fileType
	 * @return
	 *//*

	public int getFileIncrementer(String fileType) {

		fileIncrementerObject=new IncrementerEntity();
		 Set the incrementer value  

		//	fileIncrementer=fileIncrementerObject.setIncrementId(Integer.parseInt(fileType));
		logger.debug("FILE_INCREMENTER value is "+fileIncrementer);


		*//**\
		 * Get the fileIncrementer value from incrementer data table
		 * And increments the value and update the value in datatable
		 * 
		 * If no value present for that file category,it inserts the new record
		 * in the datatable.
		 *//*

		if(fileIncrementer == 1){
			logger.debug("Inserting the value in the databse");
			//		fileIncrementerObject.fileIncValue(fileIncrementer,Integer.parseInt(fileType));
		}else {
			logger.debug("Updating the database");
			//		fileIncrementerObject.fileUpdateValue(fileIncrementer,Integer.parseInt(fileType));
		}

		return fileIncrementer;
	}



	public String getFileCategory() {
		return fileCategory;
	}
	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	*//**
	 * Getting the ddMMYY format
	 *//*
	public String getCurrentDate() {

		currentDate = FileUtils.getDateStringForFileNaming();
		logger.info("Current Date "+currentDate);

		return currentDate;
	}

	*//**
	 * Formulating the file name in the format of FFDDTTTddMMYYNNN.csv
	 *   0. Get File type value
	 *   1. Get device id value (DDTTT)
	 *   2. Get date part of the file (ddMMYY)
	 *   3. Get File increment value (NNN)
	 *   4. Add extension 
	 *  5. Create a file 
	 *  6. Return file name. 
	 *//*

	public String getFileExt() {
		return fileExt;
	}


	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}


	public StringBuilder createOutputCsvFile(CsvFileCreation csvFileObj){

		StringBuilder csvFileName = new StringBuilder();

		csvFileName.append(csvFileObj.getFileCategory());
		csvFileName.append(csvFileObj.getDeviceId());
		csvFileName.append(csvFileObj.getDeviceType());
		csvFileName.append(getCurrentDate());
		csvFileName.append(csvFileObj.getFileIncrementer(csvFileObj.getFileCategory()));
		csvFileName.append(".csv");

		logger.info("Csv File Name "+csvFileName);

		return csvFileName;
	}


}
*/