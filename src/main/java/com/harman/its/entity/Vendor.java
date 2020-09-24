/**
 * @author VAmukapati
 *
 */
package com.harman.its.entity;

import com.harman.its.entity.ientity.IEntity;

/**
 * 
DROP TABLE IF EXISTS vendor
CREATE TABLE vendor(
vendor_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50),
mobile_number INT(10),
fax_number VARCHAR(50),
website VARCHAR(30),
address VARCHAR(50),
user_id INT(6) NOT NULL,
contact_person VARCHAR(30)
)
*/
public class Vendor implements IEntity<Vendor> {

	private LongPrimaryKey vendorId;
	
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String website;
	
	private String mobileNumber;
	
	private String faxNumber;
	
	private String address;
	
	private String contactPerson;

	public Vendor(LongPrimaryKey vendorId,int userId,String firstName,String lastName,String email,String website,
			String mobileNumber,String faxNumber,String address,String contactPerson) {
		this.vendorId = vendorId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.website = website;
		this.mobileNumber = mobileNumber;
		this.faxNumber = faxNumber;
		this.address = address;
		this.contactPerson = contactPerson;
	}
	
	public boolean equalsEntity(Vendor object) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the vendorId
	 */
	public LongPrimaryKey getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(LongPrimaryKey vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
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
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * @return the faxNumber
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

}
