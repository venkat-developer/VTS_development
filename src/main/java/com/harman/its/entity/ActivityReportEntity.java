package com.harman.its.entity;

import java.util.Date;

import com.harman.its.entity.ientity.IEntity;

public class ActivityReportEntity implements IEntity<ActivityReportEntity>{

	private String vehicleName;

	private long vehicleId;

	private String location;

	private Date occurredAt;

	private String speed;

	private String distance;

	private double latitude;
	
	private double longitude;
	
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getOccurredAt() {
		return occurredAt;
	}

	public void setOccurredAt(Date occurredAt) {
		this.occurredAt = occurredAt;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equalsEntity(ActivityReportEntity object) {
		// TODO Auto-generated method stub
		return false;
	}

}