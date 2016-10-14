package com.harman.its.utils;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.constants.ReportOptions;
import com.harman.its.dao.impl.TrackHistoryDaoImpl;
import com.harman.its.entity.ReportGenerateEntity;
import com.harman.its.entity.TrackHistoryEntity;

public class ReportGenerateUtils {
	Logger logger = Logger.getLogger(getClass());

	/**
	 * This method  returns the report Entity with the details of settingFiles for which the report
	 * has to be generated.
	 * @param operatorName
	 * @param fileHeader
	 * @param reportType
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ReportGenerateEntity getReportEntity(long vehicleId,String fileHeader,String reportType, Date startDate, Date endDate) 
			throws ClassNotFoundException, SQLException{
		List<TrackHistoryEntity> reportDataList=new LinkedList<TrackHistoryEntity>();
		List<String> tableColumnNamesList = new LinkedList<String>();
		ReportGenerateEntity reportEntity = null;
		String reportFileName = null;
		String reportName=null;
		logger.info("Report type is :::: "+fileHeader.toUpperCase().trim());
		TrackHistoryDaoImpl trackHistoryDaoImpl = new TrackHistoryDaoImpl();
		switch(ReportOptions.valueOf(fileHeader.toUpperCase().trim())){
		case ACTIVITY :
		logger.info("In ACTIVITY");	
		// Setting the column Names of the table
		reportFileName=fileHeader;
		tableColumnNamesList.add("S.No");
		tableColumnNamesList.add("Speed");
		tableColumnNamesList.add("Distance");
		tableColumnNamesList.add("Latitude");
		tableColumnNamesList.add("Longitude");
		tableColumnNamesList.add("Location");
		tableColumnNamesList.add("Updated At");
		reportDataList = trackHistoryDaoImpl.selectBetweenDates(vehicleId, startDate, endDate);
		//reportDataList = transactionDaoImpl.getSummaryReportData(operatorName,startDate,endDate);
		logger.debug("Reports data size is "+reportDataList.size());
		reportFileName="Activity ";
		reportName="Activity Report from "+startDate+"- to  "+endDate+"   Vehicle : "+vehicleId;
		reportEntity=new ReportGenerateEntity(reportFileName,tableColumnNamesList,reportDataList,tableColumnNamesList.size(),reportName);
		break;
		case IDLE :
			logger.info("In IDLE");	
			// Setting the column Names of the table
			reportFileName=fileHeader;
			tableColumnNamesList.add("S.No");
			tableColumnNamesList.add("Speed");
			tableColumnNamesList.add("Distance");
			tableColumnNamesList.add("Latitude");
			tableColumnNamesList.add("Longitude");
			tableColumnNamesList.add("Location");
			tableColumnNamesList.add("Updated At");
			reportDataList = trackHistoryDaoImpl.selectBetweenDates(vehicleId, startDate, endDate);
			//reportDataList = transactionDaoImpl.getSummaryReportData(operatorName,startDate,endDate);
			logger.debug("Reports data size is "+reportDataList.size());
			reportFileName="Idle ";
			reportName="Idle Report from "+startDate+"- to  "+endDate+"   Vehicle : "+vehicleId;

			reportEntity=new ReportGenerateEntity(reportFileName,tableColumnNamesList,reportDataList,tableColumnNamesList.size(),reportName);
			break;
		case STATSTICS :
			logger.info("In STATSTICS");	
			// Setting the column Names of the table
			reportFileName=fileHeader;
			
			tableColumnNamesList.add("S.No");
			tableColumnNamesList.add("VehicleName");
			tableColumnNamesList.add("Speed");
			tableColumnNamesList.add("Avg.Speed");
			tableColumnNamesList.add("Distance");
			tableColumnNamesList.add("Start Latitude");
			tableColumnNamesList.add("Start Longitude");
			tableColumnNamesList.add("Start Location");
			tableColumnNamesList.add("End Latitude");
			tableColumnNamesList.add("End Longitude");
			tableColumnNamesList.add("End Location");
			tableColumnNamesList.add("Idle Duration");
			reportDataList = trackHistoryDaoImpl.selectBetweenDates(vehicleId, startDate, endDate);
			logger.debug("Reports data size is "+reportDataList.size());
			reportFileName="Stastics ";
			reportName="Stastics Report from "+startDate+"- to  "+endDate+"   Vehicle : "+vehicleId;

			reportEntity=new ReportGenerateEntity(reportFileName,tableColumnNamesList,reportDataList,tableColumnNamesList.size(),reportName);
			break;
			
		default:
		break;
		}
		return reportEntity;
	}
}
