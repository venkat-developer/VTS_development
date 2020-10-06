/**
 * @author VAmukapati
 *
 */
package com.harman.its.entity;

import com.harman.its.entity.ientity.IEntity;

/***
 * CREATE TABLE passenger(
passanger_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50),
mobile_number INT(10),
address VARCHAR(50),
user_id INT(6) NOT NULL,
passanger_type INT(3) NOT NULL,
vendor_id INT(6)
)
*/
public class Passenger implements IEntity<Passenger> {

	private LongPrimaryKey passengerId;
	
	private long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobile;
	
	private String address;
	
	private int passengerType;
	
	private long vendorId;
	
	public Passenger() {
		
	}
	public Passenger(LongPrimaryKey passengerId,long userId,String firstName,String lastName,
				String email,String mobile,String address,int passengerType,long vendorId) {
		this.passengerId = passengerId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.passengerType = passengerType;
		this.vendorId = vendorId;
	}
	public boolean equalsEntity(Passenger object) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the vendorId
	 */
	public long getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the passengerId
	 */
	public LongPrimaryKey getPassengerId() {
		return passengerId;
	}

	/**
	 * @param passengerId the passengerId to set
	 */
	public void setPassengerId(LongPrimaryKey passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the passengerType
	 */
	public int getPassengerType() {
		return passengerType;
	}

	/**
	 * @param passengerType the passengerType to set
	 */
	public void setPassengerType(int passengerType) {
		this.passengerType = passengerType;
	}
	
}
