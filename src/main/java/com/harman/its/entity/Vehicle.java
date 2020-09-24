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
insurance_validity TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
*/
public class Vehicle implements IEntity<Vehicle> {

	private LongPrimaryKey vehicleId;
	
	private int userId;
	
	private String registrationNo;
	
	private String vehicleMake;
	
	private String vehicleModel;
	
	private String vehicleModelYear;
	
	private Date insuranceValidTill;
	
	public Vehicle(LongPrimaryKey vehcielId,int userId,String registrationNo,String vehicleMake,
				String vehicleModel,String vehicleModelYear,Date insuranceValidTill) {
		this.vehicleId = vehcielId;
		this.userId = userId;
		this.registrationNo = registrationNo;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehicleModelYear = vehicleModelYear ;
		this.insuranceValidTill = insuranceValidTill;
	}
	public LongPrimaryKey getVehcielId() {
		return vehicleId;
	}

	public void setVehcielId(LongPrimaryKey vehcielId) {
		this.vehicleId = vehcielId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
}
