/**
 * @author VAmukapati
 *
 */
package com.harman.its.entity;

import java.util.Date;

import com.harman.its.entity.ientity.IEntity;

/**
 * 
DROP TABLE IF EXISTS vehicle;
CREATE TABLE vehicle(
vehicle_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
registration_num VARCHAR(30) NOT NULL,
vehicle_type INT NOT NULL,
vehicleMake VARCHAR(50),
vehicleModel VARCHAR(50),
vehicleModelYear VARCHAR(50),
isACVehicle BOOLEAN NOT NULL DEFAULT true,
insurance_validity DATE DEFAULT (CURRENT_DATE + INTERVAL 1 YEAR)
)
*/
public class Vehicle implements IEntity<Vehicle> {

	private LongPrimaryKey vehicleId;
	
	private long userId;
	
	private String registrationNo;
	
	private String vehicleMake;
	
	private String vehicleModel;
	
	private String vehicleModelYear;
	/**
	 * Sedan,SUV,Bus ..
	 */
	private int vehicleType;
	
	private Date insuranceValidTill;
	
	private boolean isACVehicle;
	
	public Vehicle() {
		
	}
	public Vehicle(LongPrimaryKey vehcielId,long userId,String registrationNo,String vehicleMake,
				String vehicleModel,String vehicleModelYear,int vehicleType,Date insuranceValidTill,boolean isACVehicle) {
		this.vehicleId = vehcielId;
		this.userId = userId;
		this.registrationNo = registrationNo;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehicleModelYear = vehicleModelYear ;
		this.vehicleType = vehicleType;
		this.insuranceValidTill = insuranceValidTill;
		this.isACVehicle = isACVehicle;
	}
	public LongPrimaryKey getVehcielId() {
		return vehicleId;
	}

	public void setVehcielId(LongPrimaryKey vehcielId) {
		this.vehicleId = vehcielId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleModelYear() {
		return vehicleModelYear;
	}

	public void setVehicleModelYear(String vehicleModelYear) {
		this.vehicleModelYear = vehicleModelYear;
	}

	public Date getInsuranceValidTill() {
		return insuranceValidTill;
	}

	public void setInsuranceValidTill(Date insuranceValidTill) {
		this.insuranceValidTill = insuranceValidTill;
	}
	

	public boolean equalsEntity(Vehicle object) {
		return false;
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
	/**
	 * @return the isACVehicle
	 */
	public boolean isACVehicle() {
		return isACVehicle;
	}
	/**
	 * @param isACVehicle the isACVehicle to set
	 */
	public void setACVehicle(boolean isACVehicle) {
		this.isACVehicle = isACVehicle;
	}
}
