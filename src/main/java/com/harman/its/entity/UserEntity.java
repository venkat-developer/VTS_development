/**
 * @author sreekanth
 *
 */
package com.harman.its.entity;

import java.util.Date;

import com.harman.its.entity.ientity.IEntity;
/**
 * 
 DROP TABLE IF EXISTS users
CREATE TABLE users(
user_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(50) NOT NULL,
user_password VARCHAR(50) NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50),
user_role INT(6) NOT NULL,
travels_name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
mobile_number INT(10) NOT NULL,
address VARCHAR(50),
contact_person VARCHAR(30),
subscription_type INT(6) NOT NULL,
website VARCHAR(30),
registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
isActive BOOLEAN NOT NULL DEFAULT false
)
select * from users;
insert into users(user_name,user_password,first_name,last_name,user_role,travels_name,email,mobile_number,address,contact_person,subscription_type,website,isActive)
 values ('venkat','venkat','super_first','super_last',0,'SANVI','venkat@gmail.com','91644','Bengaluru','poc',1,'test.com',true)
insert into users(user_name,user_password,first_name,last_name,user_role,travels_name,email,mobile_number,address,contact_person,subscription_type,website,isActive)
 values ('admin','admin','admin_firstName','admin_lastName',1,'SANVI','admin@gmail.com','91644','Bengaluru','poc',1,'test.com',true)
 insert into users(user_name,user_password,first_name,last_name,user_role,travels_name,email,mobile_number,address,contact_person,subscription_type,website,isActive)
 values ('test','test','test','test',2,'SANVI','test@gmail.com','91644','Bengaluru','poc',1,'test.com',true)
 *
 */
public class UserEntity implements IEntity<UserEntity>{
	
	private LongPrimaryKey userId;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private UserRole userRole;
	
	private Boolean isActive;
	
	private String companyName;
	
	private String email;
	
	private String mobileNumber;
	
	private String address;
	
	private String contactPerson;
	
	private int subscriptionType;

	private String website;
	
	private Date registrationDate;

	
	public UserEntity(Long id, String userName,String password, String firstName,String lastName,int userRole,boolean isActive,String companyName, 
			String email,String mobileNumber,String address,String contactPerson,int subscriptionType,String website,Date registrationDate) {
		this.userId = new LongPrimaryKey(id);
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.companyName = companyName;
		this.userRole = UserRole.getUserRole(userRole);
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.contactPerson = contactPerson;
		this.subscriptionType = subscriptionType;
		this.website = website;
		this.registrationDate = registrationDate;
	}
	
	public String getLogin() {
		return userName;
	}
	public void setLogin(String login) {
		this.userName = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return userRole;
	}
	public void setRole(UserRole role) {
		this.userRole = role;
	}
	public void setId(LongPrimaryKey id) {
		this.userId = id;
	}
	
	public long getId() {
		return this.userId.getId();
	}
	
	public enum UserRole {
		SUPER_USER(0),ADMIN_USER(1),NORMAL_USER(2);
		
		private int val;
		
		UserRole(int value){
			this.val = value;
		}
		
		public int getValue(){
			return val;
		}		
		
		public static UserRole getUserRole(int value){
			UserRole role = NORMAL_USER;
			if(value == ADMIN_USER.getValue()){
				role = ADMIN_USER;
			}else if (value == NORMAL_USER.getValue()){
				role = NORMAL_USER;
			}else if (value == SUPER_USER.getValue()){
				role = SUPER_USER;
			}
			return role;
		}
		
	}
   @Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(getId()).append("-").append(getLogin()).append("-").append(getPassword()).append("-");
		return strBuilder.toString();
	}

	public boolean equalsEntity(UserEntity object) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * @return the subscription_type
	 */
	public int getSubscription_type() {
		return subscriptionType;
	}

	/**
	 * @param subscription_type the subscription_type to set
	 */
	public void setSubscription_type(int subscription_type) {
		this.subscriptionType = subscription_type;
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
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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
}
