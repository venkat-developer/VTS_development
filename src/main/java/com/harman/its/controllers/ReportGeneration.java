//package com.harman.its.controllers;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.SimpleFormController;
//
//import com.harman.its.entity.ReportGenerateEntity;
//import com.harman.its.utils.ExportUtils;
//import com.harman.its.utils.SessionUtils;
//
//
//
///**
// * 
// * @author HDamodaran
// *
// */
//public class ReportGeneration extends SimpleFormController {
//	private static final int BUFFER_SIZE = 4096;
//
//	Logger logger = Logger.getLogger(ReportGeneration.class);
//
//	private List<String> access;
//
//	/**
//	 * @return the access
//	 */
//	public List<String> getAccess() {
//		return access;
//	}
//
//	/**
//	 * @param access the access to set
//	 */
//	public void setAccess(List<String> access) {
//		this.access = access;
//	}
//
//	public ModelAndView handleRequestInternal(HttpServletRequest request ,HttpServletResponse response){
//		ReportGenerateEntity reportEntity;
//		ModelAndView model ;
//		if(!AuthenticationManager.validateAccess(getAccess())){
//			return new ModelAndView("home");
//		}
//		model=new ModelAndView("report");
//		logger.info("You are in report generation Controller");
//		String reportOption=request.getParameter("reportOption");
//		/**
//		 * Based on the reportOption value the operation will be performed
//		 */
//		logger.info("reportOption value "+reportOption);
//		String fileHeader=request.getParameter("heading");
//		// This settingFileOf variable gives the 
//		logger.info("Report generated for the files of"+fileHeader);
//		String fromDate=request.getParameter("from");
//		String toDate=request.getParameter("to");
//		String operatorName=request.getParameter("operatortype");
//		String reportType=request.getParameter("reportType");
//		String fromHrs=request.getParameter("fhrs");
//		String fromMin=request.getParameter("fmin");
//		String fromSec=request.getParameter("fsec");
//		String toHrs=request.getParameter("thrs");
//		String toMin=request.getParameter("tmin");
//		String toSec=request.getParameter("tsec");
//		String startDate = fromDate+" "+fromHrs+":"+fromMin+":"+fromSec;
//		String toStart = toDate+" "+toHrs+":"+toMin+":"+toSec;
//		model.addObject("from", fromDate);
//		model.addObject("to", toDate);
//		model.addObject("fhrs",fromHrs);
//		model.addObject("fmin",fromMin);
//		model.addObject("fsec", fromSec);
//		model.addObject("thrs", toHrs);
//		model.addObject("tmin", toMin);
//		model.addObject("tsec",toSec);
//		//For Transaction Reports
//		if(fileHeader.equalsIgnoreCase("transaction")){
//			model=new ModelAndView("transactions");
//			model.addObject("heading","Transaction");	
//			model.addObject("operatortype", operatorName);
//			model.addObject("reportType", reportType);
//		}else if(fileHeader.equalsIgnoreCase("alerts")){
//			model=new ModelAndView("alertReport");
//			model.addObject("heading","Alerts");
//		}
//		//Getting the value for Report Entity
//		try {
//			ReportGenerateUtils report =new ReportGenerateUtils();
//			reportEntity = report.getReportEntity(operatorName,fileHeader,reportType,startDate,toStart);
//			ExportUtils exportUtils = new ExportUtils();
//			String filePath = exportUtils.exportData(reportOption,reportEntity, reportType);
//			if(filePath!=null){
//				sendPlainFile(request, response, filePath);
//			}else{
//				logger.error("Error in creating file");
//			}
//			model.addObject("reportList", reportEntity.getReportDataList());
//			model.addObject("tableColumnNamesList",reportEntity.getTableColumnNamesList());
//			model.addObject("heading", fileHeader);
//		} catch (ClassNotFoundException e) {
//			model=new ModelAndView("error");
//			model.addObject("errorHeading","Report Generation");
//			model.addObject("errorException","ClassNotFoundException");
//			model.addObject("errorMsg", "Error in finding the class Dao and Entity of report");
//			return model;
//		} catch (SQLException e) {
//			model=new ModelAndView("error");
//			model.addObject("errorHeading","Report Generation");
//			model.addObject("errorException","SQL Exception");
//			model.addObject("errorMsg", "Error in SQL Query which inserts or retrives data from db");
//			return model;
//		}  catch (NullPointerException e) {
//			model=new ModelAndView("error");
//			model.addObject("errorHeading","Report Generation");
//			model.addObject("errorException","Null Pointer Exception");
//			model.addObject("errorMsg", "Returns NULL for generating report");
//			return model;
//		}catch (IOException e) {
//			model=new ModelAndView("error");
//			model.addObject("errorHeading","Report Generation");
//			model.addObject("errorException","IO Exception");
//			model.addObject("errorMsg", "Unexpected termination of the process.Try Uploading again");
//			return model;
//		} catch (Exception e) {
//			model=new ModelAndView("error");
//			model.addObject("errorHeading","Report Generation");
//			model.addObject("errorException","Undefined Exception");
//			model.addObject("errorMsg", e.toString());
//			return model;
//		}
//		SessionUtils.addUserDeatils(model);
//		return model;
//	}
//	public void sendPlainFile(HttpServletRequest httpRequest ,HttpServletResponse response,String inputFilePath)
//			throws IOException {
//		File downloadFile = null;
//		FileInputStream inputStream;
//		OutputStream outStream = null;
//		String tempOutPutFile = inputFilePath;
//		logger.debug("OutputFilePath path is : " + tempOutPutFile);
//		// construct the complete absolute path of the file
//		if(!(inputFilePath.equals(""))){
//			downloadFile = new File(inputFilePath);
//		}
//		logger.debug("Download file path is " + downloadFile.getAbsolutePath());
//		inputStream = new FileInputStream(downloadFile);
//		// set headers for the response
//		String headerKey = "Content-Disposition";
//		String headerValue = String.format("attachment; filename=\"%s\"",
//				downloadFile.getName());
//		// set content attributes for the response
//		response.setContentType(httpRequest.getContentType());
//		response.setContentLength((int) downloadFile.length());
//		response.setHeader(headerKey, headerValue);
//		// get output stream of the response
//		outStream = response.getOutputStream();
//		byte[] buffer = new byte[BUFFER_SIZE];
//		int bytesRead = -1;
//		// write bytes read from the input stream into the output stream
//		while ((bytesRead = inputStream.read(buffer)) != -1) {
//			outStream.write(buffer, 0, bytesRead);
//		}
//		inputStream.close();
//		outStream.close();
//	}
//}