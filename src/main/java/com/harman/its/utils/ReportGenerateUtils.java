package com.harman.its.utils;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

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
		
		//switch(SettingFileDevices.valueOf(fileHeader.toUpperCase().trim())){
		//case BUSSTOPDETAILS :
		logger.info("In BusStopDetailcase");	
		// Setting the column Names of the table
		reportFileName=fileHeader;
		tableColumnNamesList.add("S.No");
		tableColumnNamesList.add("Speed");
		tableColumnNamesList.add("Distance");
		tableColumnNamesList.add("Latitude");
		tableColumnNamesList.add("Longitude");
		tableColumnNamesList.add("Location");
		tableColumnNamesList.add("Updated At");
		logger.info("In transaction Deatils case ");	
		TrackHistoryDaoImpl trackHistoryDaoImpl = new TrackHistoryDaoImpl();
		reportDataList = trackHistoryDaoImpl.selectBetweenDates(vehicleId, startDate, endDate);
		//reportDataList = transactionDaoImpl.getSummaryReportData(operatorName,startDate,endDate);
		logger.debug("Reports data size is "+reportDataList.size());
		reportFileName="Summary";
		reportName="Summary Report from "+startDate+"- to  "+endDate+"   Operartor : "+vehicleId;

		reportEntity=new ReportGenerateEntity(reportFileName,tableColumnNamesList,reportDataList,tableColumnNamesList.size(),reportName);
		//break;
		//default:
		//break;
		//}
		return reportEntity;
	}
}
