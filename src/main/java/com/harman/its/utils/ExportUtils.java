package com.harman.its.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.harman.its.constants.ReportOptions;
import com.harman.its.entity.ReportGenerateEntity;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * Class handles all requests of Export.
 * @author VAmukapati
 *
 */
public class ExportUtils {
	Logger logger = Logger.getLogger(getClass());
	public final static String FILE_STORE = System.getenv("CATALINA_HOME").replace(";", "")+"/temp/maileports/";
	public final static String DIRECTORY_SEPERATOR = "/";

	public String exportData(String reportOption,ReportGenerateEntity reportEntity, String reportType) {
		String fileCreatedPath = null;
		switch(ReportOptions.valueOf(reportOption.toUpperCase())){
		// Generate the pdf format report
		case PDF:
			logger.info("Export- PDF format");
			fileCreatedPath = convertToPDF(reportEntity, reportType);
			break;
		case CSV:
			logger.info("Export - Csv format");
			fileCreatedPath = convertToCSV(reportEntity, reportType);
			break;
		case EXCEL:
			logger.info("Export - Excel Format");
			fileCreatedPath = convertToExcel(reportEntity, reportType);
			break;	
		case PRINT:
			logger.info("Printing the document");
			/*model=new ModelAndView("printpreview");
			model.addObject("reportSet","reportSet")*/;
			break;
		case PREVIEW:
			logger.info("Print preview the document");
			/*model.addObject("reportSet","reportSet");
			model=new ModelAndView("printpreview");*/
			break;	
		default:
			logger.info("Error in getting the options in ReportGeneration Controller");
			break;
		}
		return fileCreatedPath;
	}
	/**\
	 *
	 * Creating the new document
	 * Adding the document to the PDF Instance
	 * Opening the document and Entering the data in Table format
	 * Setting the no of columns in Table to be generated
	 * Giving the columns name and the report data from the list
	 * @param reportEntity
	 * @param reportType 
	 * @return 
	 */
	public String convertToPDF(ReportGenerateEntity reportEntity, String reportType){
		File pdfFile=null;
		try {		
			Document pdfReport=new Document(PageSize.A2);
			pdfFile = createFileDirectory(reportEntity.getTableName(),".pdf");
			PdfWriter.getInstance(pdfReport, new FileOutputStream(pdfFile));
			pdfReport.open();
			/* Adding the header to the dynamically generating Pdf*/
			Paragraph paragraph=new Paragraph(Font.BOLD);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.add(reportEntity.getReportName());
			pdfReport.add(paragraph);
			/*Inserting the blank lines*/
			pdfReport.add(Chunk.NEWLINE);		
			pdfReport.add(Chunk.NEWLINE);		
			/*Getting the name and data list from the report Entity*/
			List<String[]> reportDataList = reportEntity.getReportDataList();
			List<String> columnNameList =reportEntity.getTableColumnNamesList();
			/*Setting the no of columns in the table*/
			PdfPTable pdfTable=new PdfPTable(reportEntity.getTotalNoOfColumns());
			pdfTable.setWidthPercentage(100.0f);
			PdfPCell pdfTableCell =new PdfPCell();
			/*Iterating and getting the column names*/
			for(String columnName : columnNameList){
				pdfTableCell=new PdfPCell(new Phrase(9, columnName));
				pdfTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				pdfTableCell.setPaddingLeft(2);
				pdfTable.addCell(pdfTableCell);
			}

			/*Iterating and getting the report data*/
			if(reportEntity.getReportDataList() != null && reportEntity.getReportDataList().size() > 0){
				int serialNumber=0;
				float totalTransactionAmount = 0;
				int totalPassangers = 0;
				int totalTicketsIssued = 0;
				for(String[] reportDataValues : reportDataList){
					serialNumber++;
					pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(serialNumber)));
					pdfTable.addCell(pdfTableCell);
					for(int noOfColumns=0;noOfColumns<reportDataValues.length;noOfColumns++){
						pdfTableCell=new PdfPCell(new Phrase(7, reportDataValues[noOfColumns]));
						pdfTable.addCell(pdfTableCell);
						if(reportType.equalsIgnoreCase("detailed")){
							switch (noOfColumns) {
							case 13:
								totalTransactionAmount += Float.parseFloat(reportDataValues[noOfColumns]);
								break;
							case 19:
								totalPassangers += Integer.parseInt(reportDataValues[noOfColumns]);
								break;
							case 20:
								totalTicketsIssued += Integer.parseInt(reportDataValues[noOfColumns]);
								break;
							default: 
								break;
							}
						} else if(reportType.equalsIgnoreCase("summary")){
							switch (noOfColumns) {
							case 5:
								totalTransactionAmount += Float.parseFloat(reportDataValues[noOfColumns]);
								break;
							case 6:
								totalPassangers += Integer.parseInt(reportDataValues[noOfColumns]);
								break;
							case 7:
								totalTicketsIssued += Integer.parseInt(reportDataValues[noOfColumns]);
								break;
							default: 
								break;
							}
						}
					}
				}


				for(int i = 0; i<columnNameList.size(); i++){
					if(reportType.equalsIgnoreCase("detailed")){
						//TODO : Create the Transaction entity and get the column values to be summed from the entity 
						/*
						 *Transaction Amount Column : 13
						 *No of Passengers : 19
						 *No of Tickets : 20
						 */
						switch (i) {
						case 14:
							pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(totalTransactionAmount)));
							pdfTable.addCell(pdfTableCell);
							break;
						case 20:
							pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(totalPassangers)));
							pdfTable.addCell(pdfTableCell);
							break;
						case 21:
							pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(totalTicketsIssued)));
							pdfTable.addCell(pdfTableCell);
							break;
						default: 
							pdfTableCell=new PdfPCell(new Phrase(7, ""));
							pdfTable.addCell(pdfTableCell);
							break;
						}
					} else if(reportType.equalsIgnoreCase("summary")){
						//TODO : Create the Transaction entity and get the column values to be summed from the entity 
						/*
						 *Transaction Amount Column : 5
						 *No of Passengers : 6
						 *No of Tickets : 7
						 */
						switch (i) {
						case 6:
							pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(totalTransactionAmount)));
							pdfTable.addCell(pdfTableCell);
							break;
						case 7:
							pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(totalPassangers)));
							pdfTable.addCell(pdfTableCell);
							break;
						case 8:
							pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(totalTicketsIssued)));
							pdfTable.addCell(pdfTableCell);
							break;
						default: 
							pdfTableCell=new PdfPCell(new Phrase(7, ""));
							pdfTable.addCell(pdfTableCell);
							break;
						}
					}
				}
			}
			else{
				logger.error("Error in generating the PDF file");
				return null;
			}
			/*Attaching the pdfTable to the document*/
			pdfReport.add(pdfTable);
			pdfReport.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("File Not Found Exception while generating report in pdf "+e);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			logger.error("Document Not Found in PDF format report Generation"+e);
		}		 
		return pdfFile.getAbsolutePath();
	}
	/**
	 * Creating the Work book
	 * Inserting the Column Names and data into that
	 * Storing the newly created csv file temp folder of tomcat6
	 *  
	 * @param reportEntity
	 * @param reportType 
	 * @return
	 */
	public String convertToCSV(ReportGenerateEntity reportEntity, String reportType) {
		File csvFile=null;
		try {
			logger.info("Converting to the CSV file in ReportGenerateUtils");
			/*Getting the name and data list from the report Entity*/
			List<String[]> reportDataList = reportEntity.getReportDataList();
			List<String> columnNameList =reportEntity.getTableColumnNamesList();
			/**
			 * Creating the new csv File in the temp directory
			 */
			csvFile = createFileDirectory(reportEntity.getTableName(),".csv");

			BufferedWriter bw = null;
			try{
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile)));
				StringBuilder csvFileData=new StringBuilder();
				csvFileData.append(reportEntity.getReportName());
				csvFileData.append(",");
				bw.write(csvFileData.toString());
				bw.write("\n");
				csvFileData=new StringBuilder();
				/*Appending the column Name to the csvFile*/
				for(String columnName : columnNameList){
					csvFileData.append(columnName);
					csvFileData.append(",");
				}
				bw.write(csvFileData.toString());
				bw.write("\n");
				int serialNumber=0;
				/*Appending the data to the csv report*/
				if(reportEntity.getReportDataList() != null && reportEntity.getReportDataList().size() > 0){
					/*Reading the each row values*/
					float totalTransactionAmount = 0;
					int totalPassangers = 0;
					int totalTicketsIssued = 0;
					for(String[] reportDataValues : reportDataList){
						csvFileData=new StringBuilder();
						serialNumber++;
						csvFileData.append(serialNumber);
						csvFileData.append(",");
						/*Reading each cell value*/
						for(int noOfColumns=0;noOfColumns<reportDataValues.length;noOfColumns++){
							csvFileData.append(reportDataValues[noOfColumns]);
							csvFileData.append(",");
							if(reportType.equalsIgnoreCase("detailed")){
								switch (noOfColumns) {
								case 13:
									totalTransactionAmount += Float.parseFloat(reportDataValues[noOfColumns]);
									break;
								case 19:
									totalPassangers += Integer.parseInt(reportDataValues[noOfColumns]);
									break;
								case 20:
									totalTicketsIssued += Integer.parseInt(reportDataValues[noOfColumns]);
									break;
								default: 
									break;
								}
							} else if(reportType.equalsIgnoreCase("summary")){
								switch (noOfColumns) {
								case 5:
									totalTransactionAmount += Float.parseFloat(reportDataValues[noOfColumns]);
									break;
								case 6:
									totalPassangers += Integer.parseInt(reportDataValues[noOfColumns]);
									break;
								case 7:
									totalTicketsIssued += Integer.parseInt(reportDataValues[noOfColumns]);
									break;
								default: 
									break;
								}
							}
						}
						bw.write(csvFileData.toString());
						bw.write("\n");
					}

					if(reportType.equalsIgnoreCase("detailed")){
						//TODO : Create the Transaction entity and get the column values to be summed from the entity 
						/*
						 *Transaction Amount Column : 13
						 *No of Passengers : 19
						 *No of Tickets : 20
						 */
						csvFileData=new StringBuilder();
						for(int i = 0; i<columnNameList.size(); i++){
							switch (i) {
							case 14:
								csvFileData.append(totalTransactionAmount);
								csvFileData.append(",");
								break;
							case 20:
								csvFileData.append(totalPassangers);
								csvFileData.append(",");
								break;
							case 21:
								csvFileData.append(totalTicketsIssued);
								csvFileData.append(",");
								break;
							default: 
								csvFileData.append(",");
								break;
							}
						}
						bw.write(csvFileData.toString());
						bw.write("\n");
					} else if(reportType.equalsIgnoreCase("summary")){
						//TODO : Create the Transaction entity and get the column values to be summed from the entity 
						/*
						 *Transaction Amount Column : 5
						 *No of Passengers : 6
						 *No of Tickets : 7
						 */
						csvFileData=new StringBuilder();
						for(int i = 0; i<columnNameList.size(); i++){
							switch (i) {
							case 6:
								csvFileData.append(totalTransactionAmount);
								csvFileData.append(",");
								break;
							case 7:
								csvFileData.append(totalPassangers);
								csvFileData.append(",");
								break;
							case 8:
								csvFileData.append(totalTicketsIssued);
								csvFileData.append(",");
								break;
							default: 
								csvFileData.append(",");
								break;
							}
						}
						bw.write(csvFileData.toString());
						bw.write("\n");
					}
				}else{
					logger.error("No data in the data list for reporting in CSv format");
				}
				bw.flush();
			} catch(Exception e){
				logger.error("Error while converting report to csv",e);
			} finally {
				if(bw != null){
					bw.close();
				}
			}

		}catch (IOException e) {
			logger.error("Error in generating report in csv file :" + e);
			return null;
		}
		return csvFile.getAbsolutePath();
	}
	/**\
	 * Creating Excel book
	 * Entering the column Names and data in the excel book
	 * Storing it in the temp directory in tomcat6
	 * @param reportEntity
	 * @param reportType 
	 * @return
	 */
	public String convertToExcel(ReportGenerateEntity reportEntity, String reportType) {
		File excelFile = null;
		try {
			int rowNum=0;	
			int columnIndex=0;
			int headerColumIndex = reportEntity.getTotalNoOfColumns()/2;
			/*Getting the name and data list from the report Entity*/
			List<String[]> reportDataList = reportEntity.getReportDataList();
			List<String> columnNameList =reportEntity.getTableColumnNamesList();
			/*Creating  and placing the excel file in temp dir*/
			excelFile = createFileDirectory(reportEntity.getTableName(),".xlsx");
			FileOutputStream out=new FileOutputStream(excelFile);
			XSSFWorkbook workbook=new XSSFWorkbook();
			/*Creating the new Sheet*/
			XSSFSheet sheet=workbook.createSheet(reportEntity.getTableName()+"Report1");

			/*Placing the report header and data values in the excel Sheet*/
			/*Placing the report header*/
			XSSFRow headerRow=sheet.createRow(rowNum++);
			Cell cell1=headerRow.createCell(headerColumIndex);
			cell1.setCellValue(reportEntity.getReportName());

			/*Placing the column headers*/
			XSSFRow row=sheet.createRow(rowNum++);
			for(String columnName : columnNameList){
				Cell cell=row.createCell(columnIndex);
				cell.setCellValue(columnName);
				columnIndex++;
			}
			int serialNumber = 0;
			logger.debug("Report Entity Size : "+reportEntity.getReportDataList().size());
			/*Appending the data to the xlsx report*/
			if(reportEntity.getReportDataList() != null && reportEntity.getReportDataList().size() > 0){
				float totalTransactionAmount = 0;
				int totalPassangers = 0;
				int totalTicketsIssued = 0;
				/*Reading the each row values*/
				for(String[] reportDataValues : reportDataList){
					row=sheet.createRow(rowNum++); 
					serialNumber++;
					Cell cell=row.createCell(0);
					cell.setCellValue(serialNumber);
					/*Reading each cell value*/
					for(int noOfColumns=0,cellNo=1;cellNo<columnIndex;noOfColumns++,cellNo++){
						cell=row.createCell(cellNo);
						if(reportType.equalsIgnoreCase("detailed")){
							switch (noOfColumns) {
							case 13:
								totalTransactionAmount += Float.parseFloat(reportDataValues[noOfColumns]);
								cell.setCellValue(Float.parseFloat(reportDataValues[noOfColumns]));
								break;
							case 19:
								totalPassangers += Integer.parseInt(reportDataValues[noOfColumns]);
								cell.setCellValue(Integer.parseInt(reportDataValues[noOfColumns]));
								break;
							case 20:
								totalTicketsIssued += Integer.parseInt(reportDataValues[noOfColumns]);
								cell.setCellValue(Integer.parseInt(reportDataValues[noOfColumns]));
								break;
							default: 
								cell.setCellValue(reportDataValues[noOfColumns]);
								break;
							}
						} else if(reportType.equalsIgnoreCase("summary")){
							switch (noOfColumns) {
							case 5:
								totalTransactionAmount += Float.parseFloat(reportDataValues[noOfColumns]);
								cell.setCellValue(Float.parseFloat(reportDataValues[noOfColumns]));
								break;
							case 6:
								totalPassangers += Integer.parseInt(reportDataValues[noOfColumns]);
								cell.setCellValue(Integer.parseInt(reportDataValues[noOfColumns]));
								break;
							case 7:
								totalTicketsIssued += Integer.parseInt(reportDataValues[noOfColumns]);
								cell.setCellValue(Integer.parseInt(reportDataValues[noOfColumns]));
								break;
							default: 
								cell.setCellValue(reportDataValues[noOfColumns]);
								break;
							}
						} else {
							cell.setCellValue(reportDataValues[noOfColumns]);
						}
					}
				}
				if(reportType.equalsIgnoreCase("detailed")){
					//TODO : Create the Transaction entity and get the column values to be summed from the entity 
					/*
					 *Transaction Amount Column : 13
					 *No of Passengers : 19
					 *No of Tickets : 20
					 */
					row=sheet.createRow(rowNum++); 
					Cell cell=row.createCell(14);
					cell.setCellValue(totalTransactionAmount);
					cell=row.createCell(20);
					cell.setCellValue(totalPassangers);
					cell=row.createCell(21);
					cell.setCellValue(totalTicketsIssued);
				} else if(reportType.equalsIgnoreCase("summary")){
					//TODO : Create the Transaction entity and get the column values to be summed from the entity 
					/*
					 *Transaction Amount Column : 5
					 *No of Passengers : 6
					 *No of Tickets : 7
					 */
					row=sheet.createRow(rowNum++); 
					Cell cell=row.createCell(6);
					cell.setCellValue(totalTransactionAmount);
					cell=row.createCell(7);
					cell.setCellValue(totalPassangers);
					cell=row.createCell(8);
					cell.setCellValue(totalTicketsIssued);
				}
			}else{
				logger.error("No data in the data list");
				out.close();
				return null;
			}
			workbook.write(out);
			out.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("IO Exception while generating report in Excel Sheet"+e);
		} catch (Exception e){
			logger.error("",e);
		}
		return excelFile.getAbsolutePath();
	}
	/**
	 * Saving all the reports in day based directory structure. 
	 * @param fileExtension 
	 * @param reportEntity 
	 */
	public File createFileDirectory(String header, String fileExtension){
		String finalFileName = null;
		File dataTypeDirectory = new File(FILE_STORE);	
		if(!dataTypeDirectory.exists()){
			dataTypeDirectory.mkdir();
		}
		Calendar cal = Calendar.getInstance();
		File yearDirectory = new File(dataTypeDirectory.getAbsolutePath()+"/"+cal.get(Calendar.YEAR));
		if(!yearDirectory.exists()){
			yearDirectory.mkdir();
		}
		int month = (cal.get(Calendar.MONTH)+1);
		File monthDirectory = null;
		if(month<10){
			monthDirectory = new File(yearDirectory.getAbsolutePath()+"/0"+month);	
		}else{
			monthDirectory = new File(yearDirectory.getAbsolutePath()+"/"+month);
		}
		if(!monthDirectory.exists()){
			monthDirectory.mkdir();
		}
		int date = cal.get(Calendar.DATE);
		File dateDirectory = null;
		if(date < 10){
			dateDirectory = new File(monthDirectory.getAbsolutePath()+"/0"+date);	
		}else{
			dateDirectory = new File(monthDirectory.getAbsolutePath()+"/"+date);
		}
		if(!dateDirectory.exists()){
			dateDirectory.mkdir();
		}
		String timeStamp = (new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss")).format(new Date());
		finalFileName = dateDirectory.getAbsolutePath()+"/"+header+"_"+timeStamp+fileExtension;
		return new File(finalFileName);
	}
}
