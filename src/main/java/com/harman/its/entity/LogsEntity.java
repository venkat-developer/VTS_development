package com.harman.its.entity;

import java.util.Date;

import com.harman.its.entity.ientity.IEntity;

public class LogsEntity implements IEntity<LogsEntity>{
	private long userId;
	private Date requestedAt;
	private String log;
	private String ipAddress;
	public LogsEntity(Long userId, Date requestedAt, String ipAddress,
			String action) {
		this.userId = userId;
		this.requestedAt = requestedAt;
		this.log = action;
		this.ipAddress = ipAddress;
	}
	@Override
	public boolean equalsEntity(LogsEntity object) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @return the log
	 */
	public String getLog() {
		return log;
	}
	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the requestedAt
	 */
	public Date getRequestedAt() {
		return requestedAt;
	}
	/**
	 * @param requestedAt the requestedAt to set
	 */
	public void setRequestedAt(Date requestedAt) {
		this.requestedAt = requestedAt;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
