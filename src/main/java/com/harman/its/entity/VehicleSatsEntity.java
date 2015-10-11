package com.harman.its.entity;

import java.util.Date;

import com.harman.its.entity.ientity.IEntity;

public class VehicleSatsEntity implements IEntity<VehicleSatsEntity>{

	private String vehicleName;
	
	private long vehicleId;
	
	private double startLatitude;
	
	private double startLongitude;

	private double endLatitude;
	
	private double endLongitude;

	private String startLocation;
	
	private String endLocation;
	
	private boolean isChargerConnected;
	
	private Date startTime;
	
	private Date endTime;
	
	private double speed;
	
	private double avgspeed;
	
	private double distance;
	
	private String idleDuration;
	
	
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

	public boolean isChargerConnected() {
		return isChargerConnected;
	}

	public double getStartLatitude() {
		return startLatitude;
	}

	public void setStartLatitude(double startLatitude) {
		this.startLatitude = startLatitude;
	}

	public double getStartLongitude() {
		return startLongitude;
	}

	public void setStartLongitude(double startLongitude) {
		this.startLongitude = startLongitude;
	}

	public double getEndLatitude() {
		return endLatitude;
	}

	public void setEndLatitude(double endLatitude) {
		this.endLatitude = endLatitude;
	}

	public double getEndLongitude() {
		return endLongitude;
	}

	public void setEndLongitude(double endLongitude) {
		this.endLongitude = endLongitude;
	}

	public void setChargerConnected(boolean isChargerConnected) {
		this.isChargerConnected = isChargerConnected;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getAvgspeed() {
		return avgspeed;
	}

	public void setAvgspeed(double avgspeed) {
		this.avgspeed = avgspeed;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getIdleDuration() {
		return idleDuration;
	}

	public void setIdleDuration(String idleDuration) {
		this.idleDuration = idleDuration;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public boolean equalsEntity(VehicleSatsEntity object) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	
}