/*package com.harman.its.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.harman.its.constants.FileCategory;
import com.harman.its.entity.FareChartEntity;
import com.harman.its.entity.SettingsFileHistoryEntity;
import com.harman.its.entity.SystemConfigEntity;

@SuppressWarnings("unchecked")
public class FileCreator {

	Logger logger = Logger.getLogger(FileCreator.class);
	// TODO: Get this data from properties file
	public static final String FILE_STORE = System.getenv("CATALINA_HOME")
			.replace(";", "") + "/webapps/store/";
	public static final String DIRECTORY_SEPERATOR = "/";
	StringBuilder fileName = new StringBuilder();

	*//**
	 * 1. Form JSON object from UI inputs 2. Validate entity 3. Get file name to
	 * create 4. Create file, update DB and update the JSON object to the file
	 * 
	 * @param fileInc
	 * @param configEntity
	 * @param timestamp
	 * @return
	 * @throws IOException
	 *//*
	public SettingsFileHistoryEntity createJSONFile(int fileInc,
			SystemConfigEntity configEntity, Timestamp timestamp)
			throws IOException {
		logger.debug("Creating JSON file ");

		logger.debug("1. Form JSON object from UI inputs");
		// 1. Form JSON object from UI inputs
		JSONObject jsonObjectFile = getJSONFromUIInputs(configEntity, timestamp);

		logger.debug("2. Validate entity");
		// 2. Validate entity
		// TODO: Validate the JSON file input

		logger.debug("3. Get file name to create ");
		// 3. Get file name to create
		fileName = getFileName(
				getFileCategoryString(FileCategory.SYSTEM_CONFIG), fileInc,
				configEntity.getDeviceId());

		// 4. Create file, update DB and update the JSON object to the file
		return JsonFileCreation
				.createJSONFIle(fileInc, configEntity, jsonObjectFile,
						fileName, timestamp, FileCategory.SYSTEM_CONFIG);

	}

	*//**
	 * @param configEntity
	 * @param timestamp
	 * @return
	 *//*
	private JSONObject getJSONFromUIInputs(SystemConfigEntity configEntity,
			Timestamp timestamp) {

		JSONObject obj = new JSONObject();
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();

		JSONArray maximumFareArray = new JSONArray();
		JSONObject maximumACFare = new JSONObject();
		JSONObject maximumNonACFare = new JSONObject();

		JSONObject maximumFareACArrayObj = new JSONObject();
		JSONObject maximumFareNonACArrayObj = new JSONObject();
		for (FareChartEntity fareEntity : configEntity.getFareDataList()) {
			maximumACFare.put(fareEntity.getRouteCode(),
					fareEntity.getMaximumACFare());
			maximumNonACFare.put(fareEntity.getRouteCode(),
					fareEntity.getMaximumNonACFare());
		}

		*//**
		 * Adding the a/c maximum fare for all routes
		 *//*
		maximumFareACArrayObj.put("01", maximumACFare);
		*//**
		 * \ Adding the non a/c maximum fare for all routes
		 *//*
		maximumFareNonACArrayObj.put("02", maximumNonACFare);

		maximumFareArray.add(maximumFareACArrayObj);
		maximumFareArray.add(maximumFareNonACArrayObj);

		JSONArray rechargeConfigArray = getRechargeConfigArray();

		// Adding the inner Object
		obj2.put("config_sync_time", configEntity.getConfigSyncTime());
		obj2.put("bonus_percentage", configEntity.getBonusPercentage());
		obj2.put("card_Balance_Validity_Duration",
				configEntity.getCardBalanceValidityDuration());
		obj2.put("card_Validity_Duration",
				configEntity.getCardValidityDuration());
		obj2.put("keyB", configEntity.getKeyB());
		obj2.put("ac_minimum_fare", configEntity.getAcMinimumFare());
		obj2.put("non_ac_minimum_fare", configEntity.getNonACMinimumFare());
		obj2.put("hits_request_password", configEntity.getHitsPassword());
		// obj2.put("block_numbers_for_card_access", configEntity.getBlockNo());
		obj2.put("health_sync_interval", configEntity.getHealthSyncInterval());
		obj2.put("data_sync_interval", configEntity.getDataSyncInterval());
		obj2.put("maximum_fare", maximumFareArray);
		obj2.put("recharge_config", rechargeConfigArray);
		// Adding the outer object
		obj1.put("terminal_device_id", configEntity.getDeviceId());
		obj1.put("terminal_device_type", configEntity.getDeviceType());
		obj1.put("config_file_version", configEntity.getFileVersion());
		obj1.put("stop_id", configEntity.getStopId());
		obj1.put("bus_id", configEntity.getBusId());

		obj1.put("config_data", obj2);

		obj.put("config", obj1);
		return obj;
	}

	*//**
	 * TODO: get the values from UI
	 * 
	 * @return
	 *//*

	private JSONArray getRechargeConfigArray() {
		JSONArray rechargeConfigArray = new JSONArray();
		JSONObject permanentCardConfig = new JSONObject();
		JSONObject monthlyCardConfig = new JSONObject();

		JSONObject permanentCardArrayObject = new JSONObject();
		JSONObject monthlyCardArrayObject = new JSONObject();
		{
			permanentCardConfig.put("max", 2000);
			permanentCardConfig.put("min", 100);
			permanentCardConfig.put("multiples", 100);
			permanentCardConfig.put("cash_validity", "1M");
			permanentCardConfig.put("bonus_validity", "");
			monthlyCardConfig.put("max", 1200);
			monthlyCardConfig.put("min", 1200);
			monthlyCardConfig.put("cash_validity", "1M");
		}

		permanentCardArrayObject.put("02", permanentCardConfig);
		monthlyCardArrayObject.put("03", monthlyCardConfig);

		rechargeConfigArray.add(permanentCardArrayObject);
		rechargeConfigArray.add(monthlyCardArrayObject);
		return rechargeConfigArray;
	}

	*//**
	 * 
	 * @param fileCategory
	 * @return FileCategory type in string format of length 2 00 in case of
	 *         invalid file type
	 *//*
	private String getFileCategoryString(FileCategory fileCategory) {
		if (fileCategory.getType() < 10) {
			return "0" + fileCategory.getType();
		}
		if (fileCategory.getType() > 99) {
			return "00";
		} else {
			return String.valueOf(fileCategory.getType());
		}
	}

	*//**
	 * FF - File Type DD - Device Type TTT - 3 digits device Id dd - Date MM -
	 * Month YY - Year NNN - Increment per day
	 * 
	 * @param fileCategory
	 * @param fileInc
	 * @param deviceID
	 * @return
	 *//*
	private StringBuilder getFileName(String fileCategory, int fileInc,
			String deviceID) {

		Calendar currentDate = Calendar.getInstance();
		StringBuilder fileNames = new StringBuilder();
		logger.debug("File type is 01");
		fileNames.append(fileCategory);
		fileNames.append(deviceID);
		if (currentDate.get(Calendar.DATE) < 10) {
			fileNames.append("0" + currentDate.get(Calendar.DATE));
		} else {
			fileNames.append(currentDate.get(Calendar.DATE));
		}
		if ((currentDate.get(Calendar.MONTH) + 1) < 10) {
			fileNames.append("0" + (currentDate.get(Calendar.MONTH) + 1));
		} else {
			fileNames.append((currentDate.get(Calendar.MONTH) + 1));
		}
		fileNames.append(String.valueOf(currentDate.get(Calendar.YEAR))
				.substring(2));
		if (fileInc < 10) {
			fileNames.append("00");
			fileNames.append(fileInc);
		} else if (fileInc < 100) {
			fileNames.append("0");
			fileNames.append(fileInc);
		}

		return fileNames;
	}

	*//**
	 * 1. Form CSV object from UI inputs 2. Validate entity 3. Get file name to
	 * create 4. Create file, update DB and update the JSON object to the file
	 * in csv format
	 * 
	 * @param fileInc
	 * @param configEntity
	 * @param timestamp
	 * @param settingsFileHistoryEntity
	 * @throws IOException
	 *//*
	public void createCSVFile(int fileInc, SystemConfigEntity configEntity,
			Timestamp timestamp,
			SettingsFileHistoryEntity settingsFileHistoryEntity)
			throws IOException {
		String[] routes = { "TR-1", "TR-2", "TR-3", "TR-4", "SR-1", "SR-2",
				"SR-3", "SR-4", "SR-5", "SR-6", "SR-7", "SR-8" };
		logger.debug("Converting to CSV ");
		StringBuilder fileName = getFileName(
				getFileCategoryString(FileCategory.SYSTEM_CONFIG), fileInc,
				configEntity.getDeviceId());
		fileName.append(".csv");
		// Storing the file in the data base
		logger.info("File Utils Testing " + configEntity.getDeviceId() + " "
				+ configEntity.getDeviceType());
		String fileLocation = FILE_STORE + "config_files/csv_files";
		FileUtils fileUtils = new FileUtils(fileInc, "01", fileLocation,
				configEntity.getDeviceType(), configEntity.getDeviceId(),
				".csv", "01");
		settingsFileHistoryEntity.setCsvFileName(fileName.toString());
		settingsFileHistoryEntity.setCsvFileLocation(fileUtils
				.getFileLocation());

		// Iterate through each rows one by one
		StringBuilder stb = new StringBuilder();

		stb.append(configEntity.getDeviceType());
		stb.append(',');
		stb.append(configEntity.getDeviceId());
		stb.append(',');
		stb.append(configEntity.getFileVersion());
		stb.append(',');
		String timeStamp = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
				.format(new Date());
		stb.append(timeStamp);
		stb.append(',');
		stb.append(configEntity.getKeyB());
		stb.append(',');
		stb.append(configEntity.getHealthSyncInterval());
		stb.append(',');
		stb.append(configEntity.getDataSyncInterval());
		stb.append(',');
		stb.append(configEntity.getHitsPassword());
		stb.append(',');
		// Bonus percentage
		stb.append(configEntity.getBonusPercentage());
		stb.append(',');
		stb.append(configEntity.getAcMinimumFare());
		stb.append(',');
		stb.append(configEntity.getNonACMinimumFare());
		stb.append(',');
		stb.append("1");
		// for(int routeCount=0;routeCount<1;routeCount++){
		stb.append(',');
		stb.append("TR-4");
		stb.append(',');
		stb.append("35");
		// }
		stb.append(',');
		stb.append("12");
		for (int routeCount = 0; routeCount < 12; routeCount++) {
			stb.append(',');
			stb.append(routes[routeCount]);
			stb.append(',');
			stb.append(configEntity.getNonACMaximumFareRoutes()[routeCount]);
		}
		// TODO: Get the future file details from DB.
		stb.append(',');
		stb.append("0");// Number of future files.
		// TODO: Get the details from UI
		stb.append(',');
		stb.append("0");// Number of recharge config data count
		stb.append("\n");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(fileLocation + "/"
						+ fileName.toString()))));
		bw.write(stb.toString());
		bw.close();

	}
}*/