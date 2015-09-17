package com.harman.its.entity;

import java.util.Date;

import com.harman.its.entity.ientity.IEntity;



/**
 * Entity class for trip of the vehicle
 * @author Venkat
 *
 */
public class TripDeatils implements IEntity<TripDeatils>{

	private String vehicleName;
	private String driverName;
	private String location;
	private double latitude;
	private double longitude;
	private String vhehicleStatus;
	private boolean isChargerConnected;
	private Date updatedatedTime;
	private String imei;
	private float direction;
	private float gsmStrength;
	private float gpsStrength;
	private float batteryVolatge;
	private float speed;
	private float cummalativeDistance;
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getVhehicleStatus() {
		return vhehicleStatus;
	}
	public void setVhehicleStatus(String vhehicleStatus) {
		this.vhehicleStatus = vhehicleStatus;
	}
	public boolean isChargerConnected() {
		return isChargerConnected;
	}
	public void setChargerConnected(boolean isChargerConnected) {
		this.isChargerConnected = isChargerConnected;
	}
	public Date getUpdatedatedTime() {
		return updatedatedTime;
	}
	public void setUpdatedatedTime(Date updatedatedTime) {
		this.updatedatedTime = updatedatedTime;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public float getDirection() {
		return direction;
	}
	public void setDirection(float direction) {
		this.direction = direction;
	}
	public float getGsmStrength() {
		return gsmStrength;
	}
	public void setGsmStrength(float gsmStrength) {
		this.gsmStrength = gsmStrength;
	}
	public float getGpsStrength() {
		return gpsStrength;
	}
	public void setGpsStrength(float gpsStrength) {
		this.gpsStrength = gpsStrength;
	}
	public float getBatteryVolatge() {
		return batteryVolatge;
	}
	public void setBatteryVolatge(float batteryVolatge) {
		this.batteryVolatge = batteryVolatge;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getCummalativeDistance() {
		return cummalativeDistance;
	}
	public void setCummalativeDistance(float cummalativeDistance) {
		this.cummalativeDistance = cummalativeDistance;
	}
	@Override
	public boolean equalsEntity(TripDeatils object) {
		// TODO Auto-generated method stub
		return false;
	}

}
