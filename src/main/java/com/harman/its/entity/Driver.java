package com.harman.its.entity;

import com.harman.its.entity.ientity.IEntity;

/**
 * DROP TABLE IF EXISTS driver;
CREATE TABLE driver(
driver_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
user_id INT(6) NOT NULL,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50),
mobile_number INT(10),
licence_number VARCHAR(30) NOT NULL
)
 * @author VAmukapati
 *
 */
public class Driver implements IEntity<Driver> {
	
	private LongPrimaryKey driverId;
	
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String licenseNo;
	
	private String mobileNumber;
	
	private String email;
	
	public Driver(LongPrimaryKey driverId,int userId,String firstName,String lastName,String licenseNo,String mobileNumber,String email) {
		this.driverId = driverId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.licenseNo = licenseNo;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public LongPrimaryKey getDriverId() {
		return driverId;
	}

	public void setDriverId(LongPrimaryKey driverId) {
		this.driverId = driverId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equalsEntity(Driver object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString(Driver object) {
		StringBuilder driverString = new StringBuilder();
		driverString.append(getDriverId().getId());
		driverString.append("-");
		driverString.append(getUserId());
		driverString.append("-");
		driverString.append(getFirstName());
		driverString.append("-");
		driverString.append(getLastName());
		driverString.append("-");
		driverString.append(getLicenseNo());
		driverString.append("-");
		driverString.append(getMobileNumber());
		driverString.append("-");
		driverString.append(getEmail());
		driverString.append("-");
		return driverString.toString();
	}
	
	
}