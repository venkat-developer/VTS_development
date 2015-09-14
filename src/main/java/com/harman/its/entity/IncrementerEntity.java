package com.harman.its.entity;

import com.harman.its.entity.ientity.IEntity;

public class IncrementerEntity implements IEntity<IncrementerEntity>{

	private int incrementId;

	private int fileType;

	public IncrementerEntity(int incrementId, int fileType) {
		this.incrementId = incrementId;
		this.fileType = fileType;
	}

	public IncrementerEntity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equalsEntity(IncrementerEntity object) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the incrementId
	 */
	public int getIncrementId() {
		return incrementId;
	}

	/**
	 * @param incrementId the incrementId to set
	 */
	public void setIncrementId(int incrementId) {
		this.incrementId = incrementId;
	}

	/**
	 * @return the fileType
	 */
	public int getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

}
