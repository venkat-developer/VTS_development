package com.harman.its.entity;

/**
 * @author VAmukapati
 */
import java.util.Date;

import com.harman.its.entity.ientity.IEntity;

/**
 * DROP TABLE IF EXISTS trip_sheet CREATE TABLE trip_sheet( id INT(6) UNSIGNED
 * AUTO_INCREMENT PRIMARY KEY, trip_sheet_number INT(10) UNSIGNED NOT NULL,
 * vehicle_id INT(6) UNSIGNED NOT NULL, driver_id INT(6) UNSIGNED NOT NULL,
 * trip_type INT(6) UNSIGNED NOT NULL, ac_trip BOOLEAN NOT NULL, passanger_name
 * VARCHAR(50) NOT NULL, refferedby VARCHAR(50), user_id INT(6) NOT NULL,
 * trip_start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE
 * CURRENT_TIMESTAMP NOT NULL, trip_end_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 * ON UPDATE CURRENT_TIMESTAMP NOT NULL, tax DECIMAL(5, 4), driver_beta
 * DECIMAL(5, 4), grand_total DECIMAL(5, 4), start_km INT(10) NOT NULL, end_km
 * INT(10) NOT NULL )
 */
public class TripSheet implements IEntity<TripSheet> {

	private LongPrimaryKey id;

	private long tripSheetNumber;

	private long vehicleId;

	private long driverId;

	private long userID;

	private int tripType;

	private int vehicleType;

	private String passangerName;

	private String refferedBy;

	private Date tripStartDate;

	private Date tripEndDate;

	private double tax;

	private double driverBeta;

	private double grandTotal;

	private long startKm;

	private long endKM;

	private boolean isACTrip;

	public TripSheet(long tripId, int tripSheetNumber, long vehicleId, long driverId, int userID, int tripType,
			int vehicleType, String passangerName, String refferedBy, Date tripStartDate, Date tripEndDate, double tax,
			double driverBeta, double grandTotal, long startKm, long endKM, boolean isACTrip) {
		this.id = new LongPrimaryKey(tripId);
		this.tripSheetNumber = tripSheetNumber;
		this.vehicleId = vehicleId;
		this.driverId = driverId;
		this.userID = userID;
		this.tripType = tripType;
		this.vehicleType = vehicleType;
		this.passangerName = passangerName;
		this.refferedBy = refferedBy;
		this.tripStartDate = tripStartDate;
		this.tripEndDate = tripEndDate;
		this.tax = tax;
		this.driverBeta = driverBeta;
		this.grandTotal = grandTotal;
		this.startKm = startKm;
		this.endKM = endKM;
		this.isACTrip = isACTrip;
	}

	public TripSheet() {
		// TODO Auto-generated constructor stub
	}

	public boolean equalsEntity(TripSheet object) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the tripId
	 */
	public LongPrimaryKey getTripId() {
		return id;
	}

	/**
	 * @param tripId the tripId to set
	 */
	public void setTripId(LongPrimaryKey tripId) {
		this.id = tripId;
	}

	/**
	 * @return the tripSheetNumber
	 */
	public long getTripSheetNumber() {
		return tripSheetNumber;
	}

	/**
	 * @param tripSheetNumber the tripSheetNumber to set
	 */
	public void setTripSheetNumber(long tripSheetNumber) {
		this.tripSheetNumber = tripSheetNumber;
	}

	/**
	 * @return the vehicleId
	 */
	public long getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the driverId
	 */
	public long getDriverId() {
		return driverId;
	}

	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	/**
	 * @return the tripType
	 */
	public int getTripType() {
		return tripType;
	}

	/**
	 * @param tripType the tripType to set
	 */
	public void setTripType(int tripType) {
		this.tripType = tripType;
	}

	/**
	 * @return the passangerName
	 */
	public String getPassangerName() {
		return passangerName;
	}

	/**
	 * @param passangerName the passangerName to set
	 */
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	/**
	 * @return the refferedBy
	 */
	public String getRefferedBy() {
		return refferedBy;
	}

	/**
	 * @param refferedBy the refferedBy to set
	 */
	public void setRefferedBy(String refferedBy) {
		this.refferedBy = refferedBy;
	}

	/**
	 * @return the tripStartDate
	 */
	public Date getTripStartDate() {
		return tripStartDate;
	}

	/**
	 * @param tripStartDate the tripStartDate to set
	 */
	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	/**
	 * @return the tripEndDate
	 */
	public Date getTripEndDate() {
		return tripEndDate;
	}

	/**
	 * @param tripEndDate the tripEndDate to set
	 */
	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * @return the driverBeta
	 */
	public double getDriverBeta() {
		return driverBeta;
	}

	/**
	 * @param driverBeta the driverBeta to set
	 */
	public void setDriverBeta(double driverBeta) {
		this.driverBeta = driverBeta;
	}

	/**
	 * @return the grandTotal
	 */
	public double getGrandTotal() {
		return grandTotal;
	}

	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	/**
	 * @return the startKm
	 */
	public long getStartKm() {
		return startKm;
	}

	/**
	 * @param startKm the startKm to set
	 */
	public void setStartKm(long startKm) {
		this.startKm = startKm;
	}

	/**
	 * @return the endKM
	 */
	public long getEndKM() {
		return endKM;
	}

	/**
	 * @param endKM the endKM to set
	 */
	public void setEndKM(long endKM) {
		this.endKM = endKM;
	}

	/**
	 * @return the isACTrip
	 */
	public boolean isACTrip() {
		return isACTrip;
	}

	/**
	 * @param isACTrip the isACTrip to set
	 */
	public void setACTrip(boolean isACTrip) {
		this.isACTrip = isACTrip;
	}

	/**
	 * @return the vehicleType
	 */
	public int getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String toString() {
		StringBuffer tripString = new StringBuffer();
		tripString.append("TripSheet no : ");
		tripString.append(tripSheetNumber);
		tripString.append(" , vehicleId : ");
		tripString.append(vehicleId);
		tripString.append(" , driverId: ");
		tripString.append(driverId);
		tripString.append(" , isACTrip: ");
		tripString.append(isACTrip);
		tripString.append(" , vehicleType : ");
		tripString.append(vehicleType);
		tripString.append(" , tripType : ");
		tripString.append(tripType);
		tripString.append(" , passangerNameL :");
		tripString.append(passangerName);
		tripString.append(" , refferedBy : ");
		tripString.append(refferedBy);
		tripString.append(" , userID : ");
		tripString.append(userID);
		tripString.append(" , tripStartDate : ");
		tripString.append(tripStartDate);
		tripString.append(" , tripEndDate : ");
		tripString.append(tripEndDate);
		tripString.append(" , tax : ");
		tripString.append(tax);
		tripString.append(" , driverBeta : ");
		tripString.append(driverBeta);
		tripString.append(" , grandTotal : ");
		tripString.append(grandTotal);
		tripString.append(" , startKm : ");
		tripString.append(startKm);
		tripString.append(" , endKM : ");
		tripString.append(endKM);
		return tripString.toString();
	}
}
