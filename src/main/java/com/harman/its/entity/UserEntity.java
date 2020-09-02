/**
 * 
 */
package com.harman.its.entity;

import com.harman.its.entity.ientity.IEntity;

/**
 * @author sreekanth
 *
 */
public class UserEntity implements IEntity<UserEntity>{
	
	public enum UserRole {
		ADMIN_USER(1),NORMAL_USER(2),SUPER_USER(0);
		
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

	public enum UserStatus {
		USER_ACTIVE(0),USER_DELETED(1);
		
		private int val;
		
		UserStatus(int value){
			this.val = value;
		}
		public int getValue(){
			return val;
		}
		
		public static UserStatus getUserStatus(int value){
			UserStatus userStatus = USER_ACTIVE;
			if(value == USER_ACTIVE.getValue()){
				userStatus = USER_ACTIVE;
			}else if (value == USER_DELETED.getValue()){
				userStatus = USER_DELETED;
			}
			return userStatus;
		}
		
	}
	
	private LongPrimaryKey id;
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private Long groupId;
	private UserRole role;
	private UserStatus userStatus;
	private Long ownerId;
	private Boolean isActive;
	
	
	private int offroadCount;
	private int noGPRSCount;

	public UserEntity(Long id, String login, String password, Long groupId, Long owner_id,String firstname,String lastname, int offroadCount, int noGPRSCount) {
		super();
		this.id = new LongPrimaryKey(id);
		this.login = login;
		this.password = password;
		this.groupId = groupId;
		this.ownerId = owner_id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.offroadCount = offroadCount;
		this.noGPRSCount = noGPRSCount;
	}
	public UserEntity(Long id, String login, String password,String firstname,String lastname,int role,boolean isActive) {
		super();
		this.id = new LongPrimaryKey(id);
		this.login = login;
		this.password = password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.isActive = isActive;
		this.role = UserRole.getUserRole(role);
	}
	
	public UserEntity(String login, String password, Long ownerId, String firstname, String Lastname, Long groupId) {
		super();
		this.firstname=firstname;
		this.lastname=Lastname;
		this.login = login;
		this.password = password;
		this.groupId = groupId;
		this.role = UserRole.NORMAL_USER;
		this.userStatus = UserStatus.USER_ACTIVE;
		this.ownerId = ownerId;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public UserEntity(Long id,String login, String password, Long ownerId) {
		super();
		this.id=new LongPrimaryKey(id);
		this.login = login;
		this.password = password;
		this.role = UserRole.NORMAL_USER;
		this.userStatus = UserStatus.USER_ACTIVE;
		this.ownerId = ownerId;
	}
	public Long getGroupId(){
		return groupId;
	}
	
	public void setGroupId(Long groupId){
		this.groupId = groupId;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus status) {
		userStatus = status;
	}

	public void setId(LongPrimaryKey id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id.getId();
	}
	
   public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getOwnerId() {
		return ownerId;
	}
	
	public int getOffroadCount() {
		return offroadCount;
	}

	public void setOffroadCount(int offroadCount) {
		this.offroadCount = offroadCount;
	}

	public int getNoGPRSCount() {
		return noGPRSCount;
	}

	public void setNoGPRSCount(int noGPRSCount) {
		this.noGPRSCount = noGPRSCount;
	}

	@Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(getId()).append("-").append(getLogin()).append("-").append(getPassword()).append("-");
		strBuilder.append(getRole()).append("-").append(getUserStatus());
		return strBuilder.toString();
	}

	@Override
	public boolean equalsEntity(UserEntity object) {
		// TODO Auto-generated method stub
		return false;
	}
}
