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
import com.harman.its.entity.TrackHistoryEntity;
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
			List<TrackHistoryEntity> reportDataList = reportEntity.getReportDataList();
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
				for(TrackHistoryEntity reportDataValues : reportDataList){
					
					serialNumber++;
					pdfTableCell=new PdfPCell(new Phrase(7, String.valueOf(serialNumber)));
					pdfTable.addCell(pdfTableCell);
					pdfTableCell=new PdfPCell(new Phrase(7, reportDataValues.getSpeed()+""));
					pdfTable.addCell(pdfTableCell);
					pdfTableCell=new PdfPCell(new Phrase(7, reportDataValues.getDistance()+""));
					pdfTable.addCell(pdfTableCell);

					pdfTableCell=new PdfPCell(new Phrase(7, reportDataValues.getLocation().getFirstPoint().getX()+""));
					pdfTable.addCell(pdfTableCell);

					pdfTableCell=new PdfPCell(new Phrase(7, reportDataValues.getLocation().getFirstPoint().getX()+""));
					pdfTable.addCell(pdfTableCell);

					pdfTableCell=new PdfPCell(new Phrase(7, reportDataValues.getLocation().getFirstPoint().y+":"+reportDataValues.getLocation().getFirstPoint().x));
					pdfTable.addCell(pdfTableCell);

					pdfTableCell=new PdfPCell(new Phrase(7, reportDataValues.getOccurredat()+""));
					pdfTable.addCell(pdfTableCell);
				}
			}else{
				logger.error("Error in generating the PDF file");
				return null;
			}
			/*Attaching the pdfTable to the document*/
			pdfReport.add(pdfTable);
			pdfReport.close();
		}catch (FileNotFoundException e) {
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
			//Getting the name and data list from the report Entity
			List<TrackHistoryEntity> reportDataList = reportEntity.getReportDataList();
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
				//Appending the column Name to the csvFile
				for(String columnName : columnNameList){
					csvFileData.append(columnName);
					csvFileData.append(",");
				}
				bw.write(csvFileData.toString());
				bw.write("\n");
				int serialNumber=0;
				//Appending the data to the csv report
				if(reportEntity.getReportDataList() != null && reportEntity.getReportDataList().size() > 0){
					//Reading the each row values
					for(TrackHistoryEntity reportDataValues : reportDataList){
						csvFileData=new StringBuilder();
						serialNumber++;
						csvFileData.append(serialNumber);
						csvFileData.append(",");
						//Reading each cell value
						csvFileData.append(Float.parseFloat(reportDataValues.getSpeed()+""));
						csvFileData.append(",");
						csvFileData.append(reportDataValues.getDistance()+"");
						csvFileData.append(",");
						csvFileData.append(reportDataValues.getLocation().getFirstPoint().getX()+"");
						csvFileData.append(",");
						csvFileData.append(reportDataValues.getLocation().getFirstPoint().getY()+"");
						csvFileData.append(",");
						csvFileData.append(Float.parseFloat(reportDataValues.getSpeed()+""));
						csvFileData.append(",");
						csvFileData.append(reportDataValues.getLocation().getFirstPoint().y+":"+reportDataValues.getLocation().getFirstPoint().x);
						csvFileData.append(",");
						csvFileData.append(reportDataValues.getOccurredat()+"");
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
			//Getting the name and data list from the report Entity
			List<TrackHistoryEntity> reportDataList = reportEntity.getReportDataList();
			List<String> columnNameList =reportEntity.getTableColumnNamesList();
			//Creating  and placing the excel file in temp dir
			excelFile = createFileDirectory(reportEntity.getTableName(),".xlsx");
			FileOutputStream out=new FileOutputStream(excelFile);
			XSSFWorkbook workbook=new XSSFWorkbook();
			//Creating the new Sheet
			XSSFSheet sheet=workbook.createSheet(reportEntity.getTableName()+"Report1");

			/*Placing the report header and data values in the excel Sheet
			Placing the report header*/
			XSSFRow headerRow=sheet.createRow(rowNum++);
			Cell cell1=headerRow.createCell(headerColumIndex);
			cell1.setCellValue(reportEntity.getReportName());

			//Placing the column headers
			XSSFRow row=sheet.createRow(rowNum++);
			for(String columnName : columnNameList){
				Cell cell=row.createCell(columnIndex);
				cell.setCellValue(columnName);
				columnIndex++;
			}
			int serialNumber = 0;
			logger.debug("Report Entity Size : "+reportEntity.getReportDataList().size());
			//Appending the data to the xlsx report
			if(reportEntity.getReportDataList() != null && reportEntity.getReportDataList().size() > 0){
				//Reading the each row values
				for(TrackHistoryEntity reportDataValues : reportDataList){
					row=sheet.createRow(rowNum++); 
					serialNumber++;
					Cell cell=row.createCell(0);
					cell.setCellValue(serialNumber);
					//Reading each cell value
					cell=row.createCell(1);
					cell.setCellValue(Float.parseFloat(reportDataValues.getSpeed()+""));

					cell=row.createCell(2);
					cell.setCellValue(Float.parseFloat(reportDataValues.getDistance()+""));

					cell=row.createCell(3);
					cell.setCellValue(reportDataValues.getLocation().getFirstPoint().getX()+"");

					cell=row.createCell(4);
					cell.setCellValue(reportDataValues.getLocation().getFirstPoint().getY()+"");

					cell=row.createCell(5);
					cell.setCellValue(reportDataValues.getLocation().getFirstPoint().y+":"+reportDataValues.getLocation().getFirstPoint().x);

					cell=row.createCell(6);
					cell.setCellValue(reportDataValues.getOccurredat()+"");
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
