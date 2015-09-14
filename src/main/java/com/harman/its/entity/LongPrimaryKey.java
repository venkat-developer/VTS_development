package com.harman.its.entity;

import java.io.Serializable;

import com.harman.its.entity.ientity.IPrimaryKey;

public class LongPrimaryKey implements IPrimaryKey , Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private Long id;
	
	public LongPrimaryKey(Long id){
		this.id = id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
}
