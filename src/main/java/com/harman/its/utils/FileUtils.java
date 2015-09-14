/*package com.harman.its.utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
*//**
 * Handles all file relatd requests
 * 
 * @author VAmukapati
 *
 *//*
public class FileUtils {
	static private Logger logger = Logger.getLogger(FileUtils.class);
	String FILE_STORE = System.getenv("CATALINA_HOME").replace(";", "")+"/webapps/store/";
	String DIRECTORY_SEPERATOR = "/";
	*//**
	 * Incremental number. 000 to 999 . To be reset to 0 on the start of everyday. 
	 *//*
	private int fileIncrementer;

	private String fileType;

	private String fileLocation;

	private String deviceType;

	private String deviceId;

	private String fileCategory;

	private String extension;
	*//**
	 * @param fileIncrementer
	 * @param fileType
	 * @param fileLocation
	 * @param deviceType
	 * @param deviceId
	 * @param extension
	 * @param fileCategory
	 *//*
	public FileUtils(int fileIncrementer,String fileType,String fileLocation,String deviceType,String deviceId,String extension,String fileCategory){
		this.fileIncrementer = fileIncrementer;
		this.fileType = fileType;
		this.fileLocation = fileLocation;
		this.deviceType=deviceType;
		this.deviceId=deviceId;
		this.extension=extension;
		this.fileCategory=fileCategory;
	} 
	*//**
	 * Save uploaded file to a defined location on the server
	 * @param uploadedInputStream
	 * @param fileLocation  - farechart/wifi/bustop etc..
	 * @throws ClassNotFoundException 
	 *//*
	@SuppressWarnings({ "rawtypes" })
	public void saveFile(HttpServletRequest request,FileUtils fileUtils) throws ClassNotFoundException {
		Iterator fileNamesIterator = ((MultipartHttpServletRequest) request).getFileNames();
		while(fileNamesIterator.hasNext()) {
			String requestFileName = (String) fileNamesIterator.next();
			logger.debug("File Name is "+requestFileName);
			MultipartFile file = ((MultipartHttpServletRequest) request).getFile(requestFileName);
			String itemName =null;
			try{ 
				itemName= file.getOriginalFilename();
				logger.debug("Item Name is "+itemName);
			}catch(Exception e){
				logger.error("Error while iterating through the file names",e);
			}
			String reg = "[.*]";
			String replacingtext = "";

			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(itemName);
			StringBuffer buffer = new StringBuffer();

			while (matcher.find()) {
				matcher.appendReplacement(buffer, replacingtext);
			}
			*//**
			 * FF   - File Type 
			 * DD   - Device Type
			 * TTT	- 3 digits device Id
			 * dd	- Date
			 * MM	- Month
			 * YY	- Year
			 * NNN	- Increment per day 
			 *//*
			StringBuilder fileNames = new StringBuilder();
			logger.debug("File type is "+fileUtils.getFileType());

			// Setting the file type
			fileNames.append(fileUtils.getFileType());
			//Setting device type
			fileNames.append(fileUtils.getDeviceType());
			// Setting the device ID
			fileNames.append(fileUtils.getDeviceId());
			//Setting the dd MM YY
			fileNames.append(getDateStringForFileNaming());

			// Setting the file incrementor
			fileNames.append(getIncrementString(fileIncrementer));
			
			//Setting the file extension
			fileNames.append(fileUtils.getExtension());
			File finalFile;
			finalFile = new File(FILE_STORE+fileUtils.getFileLocation()+DIRECTORY_SEPERATOR+fileNames.toString());


			DateFormat dateFormat;
			Date date=new Date();
			dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateFormat.format(date);
			Timestamp timestamp=new Timestamp(date.getTime());

			SettingsFileHistoryEntity fileHistoryEntity = new SettingsFileHistoryEntity(fileNames.toString(), fileUtils.getDeviceId(), timestamp,
					FILE_STORE+fileUtils.getFileLocation(),Integer.parseInt(fileUtils.getFileType()), Integer.parseInt(fileUtils.getFileCategory())
					, Integer.parseInt(fileUtils.getDeviceType()));
			SettingsFileHistoryDaoImpl fileHistoryDaoImpl = new SettingsFileHistoryDaoImpl();
			fileHistoryDaoImpl.insert(fileHistoryEntity);	


			try {
				file.transferTo(finalFile);
				converToCSV(finalFile);
				logger.debug("UPLOAD : file transfered to "+finalFile.getAbsolutePath());
				//finalFile.delete();

			} catch (IllegalStateException e) {
				logger.debug("Error while transfering file",e);
			} catch (IOException e1) {
				logger.error("Error while generating file",e1);
			}
		} 			
	}
	
	public static String getIncrementString(int fileIncrementer) {
		StringBuffer incrementString = new StringBuffer();
		if(fileIncrementer<10){
			incrementString.append("00");
			incrementString.append(fileIncrementer);
		}else if (fileIncrementer<100){
			incrementString.append("0");
			incrementString.append(fileIncrementer);
		} else if(fileIncrementer < 1000){
			incrementString.append(fileIncrementer);
		} else {
			logger.error("Invalid file name");
		}
		return incrementString.toString();
	}
	
	*//**
	 * @return
	 * ddMMYY
	 *//*
	public static String getDateStringForFileNaming() {
		StringBuffer dateStringForFileName = new StringBuffer();
		Calendar currentDate = Calendar.getInstance();
		if(currentDate.get(Calendar.DATE)<10){
			dateStringForFileName.append("0"+currentDate.get(Calendar.DATE));
		}else{
			dateStringForFileName.append(currentDate.get(Calendar.DATE));	
		}
		if((currentDate.get(Calendar.MONTH)+1)<10){
			dateStringForFileName.append("0"+(currentDate.get(Calendar.MONTH)+1));
		}else{
			dateStringForFileName.append((currentDate.get(Calendar.MONTH)+1));	
		}  
		dateStringForFileName.append(String.valueOf(currentDate.get(Calendar.YEAR)).substring(2));
		return dateStringForFileName.toString();
	}
	public String getFileCategory() {
		return fileCategory;
	}


	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}


	private void converToCSV(File finalFile) {
		logger.debug("Converting to CSV ");
		Calendar currentDate = Calendar.getInstance();
		FileInputStream file;
		try {
			file = new FileInputStream(finalFile);
			//Create Workbook instance holding reference to .xlsx file

			logger.info("Creating the csv file");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows one by one
			StringBuilder stb = new StringBuilder();
			int noOfRows = sheet.getLastRowNum();
			for(int rowIndex=1;rowIndex<noOfRows;rowIndex++){
				Row row =  sheet.getRow(rowIndex);
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					logger.debug(cell.getCellType());
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						stb.append(cell.getStringCellValue());
						stb.append(",");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						stb.append(cell.getNumericCellValue());
						stb.append(",");
						break;
					default:
						break;
					}
				}
				stb.append('Y');
				stb.append(',');
				stb.append('N');
				stb.append(',');
				long time=currentDate.getTimeInMillis();
				long date=currentDate.get(Calendar.DATE);
				stb.append(time);
				stb.append(" ");
				stb.append(date);

				stb.append("\n");
			}
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(finalFile.getAbsolutePath())));
			bw.write(stb.toString());
			bw.close();
		} catch (FileNotFoundException e) {
			logger.error("File not found exception ",e);
		} catch (IOException e) {
			logger.error("Error while reading excel file ",e);
		}
	}

	public int getFileIncrementer() {
		return fileIncrementer;
	}
	public void setFileIncrementer(int fileIncrementer) {
		this.fileIncrementer = fileIncrementer;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileCategory) {
		this.fileLocation = fileCategory;
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


	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
}
*/