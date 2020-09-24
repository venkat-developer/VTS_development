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
public class VendorAgreement implements IEntity<VendorAgreement> {

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

	public boolean equalsEntity(VendorAgreement object) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
