package com.harman.its.entity;

import java.sql.Timestamp;

public class PassKeyEntity {
	String new_password;
	Timestamp changed_time;
	boolean isActive;
	
	public PassKeyEntity(){
		
	}
	public PassKeyEntity(String new_password, Timestamp changed_time,boolean isActive) {
		this.new_password = new_password;
		this.changed_time = changed_time;
		this.isActive = isActive;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public Timestamp getChanged_time() {
		return changed_time;
	}
	public void setChanged_time(Timestamp changed_time) {
		this.changed_time = changed_time;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
