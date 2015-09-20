package com.harman.its.entity;




import java.util.Calendar;
import java.util.Date;

import com.harman.its.entity.ientity.IEntity;

public class TripsEntity implements IEntity<TripsEntity> {

	private LongPrimaryKey id;
	private String tripName;
	private Date startDate;
	private boolean overrideFuelCalibration;
	private float speedLimit;
	private long vehicleId;
	private long driverId;
	private String destination;
	private boolean scheduledTrip;
	private Date endDate;
	private boolean activeTrip;
	private float cumulativeDistance;
	private int idlePointsTimeLimit;
	// change this with the geofence class in the end

	private long geoFenceId;
	private boolean maileSent;
	private int startAdValue;
	
	private TripsEntity staticTripDetails;

	private LiveVehicleStatus dynamicTripStatus;

	private Vehicle vehicle;

	private Driver driver;

	public TripsEntity getStaticTripDetails() {
		return staticTripDetails;
	}

	public void setStaticTripDetails(TripsEntity staticTripDetails) {
		this.staticTripDetails = staticTripDetails;
	}

	public LiveVehicleStatus getDynamicTripStatus() {
		return dynamicTripStatus;
	}

	public void setDynamicTripStatus(LiveVehicleStatus dynamicTripStatus) {
		this.dynamicTripStatus = dynamicTripStatus;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getDriverName() {
		return vehicleName;
	}

	public void setDriverName(String driverName) {
		this.vehicleName = driverName;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Long getGroupValue() {
		return groupValue;
	}

	public void setGroupValue(Long groupValue) {
		this.groupValue = groupValue;
	}

	public String getAlertstatus() {
		return alertstatus;
	}

	public void setAlertstatus(String alertstatus) {
		this.alertstatus = alertstatus;
	}

	private String groupName;
	
	private String vehicleName;
	
	private String driverName;

	private Long groupValue;

	private String alertstatus;
    
    public TripsEntity(Long id, String tripName, Date startDate, boolean overrideFuelCalibration, float speedLimit, long vehicleId,
            long driverId, String destination, boolean scheduledTrip, Date endDate, boolean activeTrip, float cumulativeDistance,
            long geoFenceId, boolean mailSent, int startADValue,int idlePointsTimeLimit) {
        super();
        this.id = new LongPrimaryKey(id);
        this.tripName = tripName;
        this.startDate = startDate;
        this.overrideFuelCalibration = overrideFuelCalibration;
        this.speedLimit = speedLimit;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.destination = destination;
        this.scheduledTrip = scheduledTrip;
        this.endDate = endDate;
        this.activeTrip = activeTrip;
        this.cumulativeDistance = cumulativeDistance;
        this.geoFenceId = geoFenceId;
        this.maileSent = mailSent;
        this.startAdValue = startADValue;
        this.idlePointsTimeLimit = idlePointsTimeLimit;
     
    }
 
	public TripsEntity(float speedLimit, long vehicleId, long driverId, int idlePointsTimeLimit,String tripName) {
		super();
		Calendar calendar = Calendar.getInstance();
		Date date=calendar.getTime();
		this.tripName = tripName;
		this.overrideFuelCalibration = false;
		this.speedLimit = speedLimit;
		this.vehicleId = vehicleId;
		this.driverId = driverId;
		this.destination = "delhi";
		this.scheduledTrip = false;
		this.activeTrip = true;
		this.startDate = date;
		this.endDate = null;
		this.cumulativeDistance = 0;

		this.idlePointsTimeLimit = idlePointsTimeLimit;
	}

	public TripsEntity() {
		// TODO Auto-generated constructor stub
	}

	public long getGeoFenceId() {
		return geoFenceId;
	}

	public void setGeoFenceId(long geoFenceId) {
		this.geoFenceId = geoFenceId;
	}

	public boolean isMaileSent() {
		return maileSent;
	}

	public void setMaileSent(boolean maileSent) {
		this.maileSent = maileSent;
	}

	public int getStartAdValue() {
		return startAdValue;
	}

	public void setStartAdValue(int startAdValue) {
		this.startAdValue = startAdValue;
	}

	public LongPrimaryKey getId() {
		return id;
	}

	public void setId(LongPrimaryKey id) {
		this.id = id;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isOverrideFuelCalibration() {
		return overrideFuelCalibration;
	}

	public void setOverrideFuelCalibration(boolean overrideFuelCalibration) {
		this.overrideFuelCalibration = overrideFuelCalibration;
	}

	public float getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(float speedLimit) {
		this.speedLimit = speedLimit;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public boolean isScheduledTrip() {
		return scheduledTrip;
	}

	public void setScheduledTrip(boolean scheduledTrip) {
		this.scheduledTrip = scheduledTrip;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActiveTrip() {
		return activeTrip;
	}

	public void setActiveTrip(boolean activeTrip) {
		this.activeTrip = activeTrip;
	}

	public float getCumulativeDistance() {
		return cumulativeDistance;
	}

	public void setCumulativeDistance(float cumulativeDistance) {
		this.cumulativeDistance = cumulativeDistance;
	}
	
	public int getIdlePointsTimeLimit() {
        return idlePointsTimeLimit;
    }
     
    public void setIdlePointsTimeLimit(int idlePointsTimeLimit) {
        this.idlePointsTimeLimit = idlePointsTimeLimit;
    }

   @Override
    public String toString(){
    	StringBuffer returnString = new StringBuffer();
    	returnString.append("TripID = ");
    	returnString.append(id.getId());
    	returnString.append(", TripName = ");
    	returnString.append(tripName);
    	returnString.append(", VehicleID = ");
    	returnString.append(vehicleId);
    	returnString.append(", DriverID = ");
    	returnString.append(driverId);
    	returnString.append(", StartDate = ");
    	returnString.append(startDate.toString());
    	returnString.append(", EndDate = ");
    	if(endDate != null){
    		returnString.append(endDate.toString());
    	} else {
    		returnString.append("null");
    	}
    	returnString.append(", IsActive = ");
    	returnString.append(activeTrip);
    	return returnString.toString();
    }

	@Override
	public boolean equalsEntity(TripsEntity object) {
		// TODO Auto-generated method stub
		return false;
	}
	public TripsEntity toMap(){
		//LOG.debug("Inside toMap()");
		StringBuffer location=new StringBuffer();
		TripsEntity liveVehicleStatus = new TripsEntity();
		liveVehicleStatus.setVehicleId(1234521234);
		liveVehicleStatus.setVehicleName("Harman");
		/*liveVehicleStatus.put("make", vehicle.getMake()+"");
		double a = dynamicTripStatus.getLocation().getFirstPoint().y;
		double b = dynamicTripStatus.getLocation().getFirstPoint().x;
		String statusofVeh = vehicle.getStatus(vehicle.getImei());
		liveVehicleStatus.put("status", statusofVeh+"");
		if(Boolean.valueOf(EnvironmentInfo.getProperty("IS_ADDRESS_FETCH_TRIP_DETAILS_ENABLED"))){
			Address locationFetch = GeoUtils.fetchNearestLocationFromCache(a, b);
			location=StringUtils.formulateAddress(locationFetch,vehicle.getId().getId(),a,b);
		}else {
			location.append("Trip ");
			location.append(StringUtils.addressFetchDisabled(vehicle.getId().getId(),a,b).toString());
		}
		//		location.append(a+":"+b);
		liveVehicleStatus.put("refid","not Available");
		liveVehicleStatus.put("alertstatus","Status Not Available");
		liveVehicleStatus.put("violationtype","Alert Not Available");*/

		liveVehicleStatus.setDriverId(123456);
		liveVehicleStatus.setDriverName("Driver");
		//liveVehicleStatus.set("driverstatus", dynamicTripStatus.isIdle()?"idle":"online");
		//liveVehicleStatus.put("driverfirstname", driver.getFirstName()+"");
		//liveVehicleStatus.put("mobilenumber", driver.getLastName()+"");
		//liveVehicleStatus.put("drivermaxspeed", dynamicTripStatus.getMaxSpeed()+"");
		//liveVehicleStatus.put("driveravgspeed", 01);
		//liveVehicleStatus.put("driverdistance", 53);
		//liveVehicleStatus.put("driverassigned", true);
		//liveVehicleStatus.put("drivergroupid", "group-10");
		//liveVehicleStatus.put("drivergroupname", "South Zone");
		//liveVehicleStatus.put("course", dynamicTripStatus.getCourse()+"");
		
		/*if(statusofVeh.equalsIgnoreCase("offline") || statusofVeh.equalsIgnoreCase("offroad")){
			liveVehicleStatus.put("speed", 0+"");
			liveVehicleStatus.put("maxspeed", 0+"");
		}else{
			liveVehicleStatus.put("speed", Utils.doubleForDisplay(dynamicTripStatus.getMaxSpeed())+"");
			liveVehicleStatus.put("maxspeed", Utils.doubleForDisplay(dynamicTripStatus.getMaxSpeed())+"");
		}*/

		/*liveVehicleStatus.set("location", location.toString());
		liveVehicleStatus.put("icon", vehicle.getVehicleIconPicId()+"");
		liveVehicleStatus.put("lat", dynamicTripStatus.getLocation().getFirstPoint().getY()+"");
		liveVehicleStatus.put("lon", dynamicTripStatus.getLocation().getFirstPoint().getX()+"");
		liveVehicleStatus.put("cc", dynamicTripStatus.isChargerConnected() ? "Yes" : "No");
		liveVehicleStatus.put("startlocation", "Bommanahalli");
		liveVehicleStatus.put("seatbelt","Not Available");
		liveVehicleStatus.put("ignition","Not Available");
		EmriVehiclesBaseStation cachedEmriRajasthan = null;

		if(Boolean.valueOf(EnvironmentInfo.getProperty("IS_FRS_EMRI_CLIENT"))){
			List<EmriVehiclesBaseStation> emriList = ((EmriVehiclesBaseStationDaoImp)DBManager.getInstance().
					getDao(DAOEnum.EMRI_RAJASTHAN_DAO)).selectByVehicleId(vehicle.getId().getId());
			if(emriList != null && emriList.size() > 0){
				Long emriRajasthanId = emriList.get(0).getID().getId();
				cachedEmriRajasthan = LoadEmriVehiclesBaseStationDetails.getInstance().retrieve(emriRajasthanId);
			}
			liveVehicleStatus.put("latestbuttonpressed", ButtonCode.get(dynamicTripStatus.getLatestButtonPressed())+"");
			liveVehicleStatus.put("name", vehicle.getDisplayName());	
			liveVehicleStatus.put("displaydata", vehicle.getDisplayName() + "    [" + driver.getFirstName() +"]");
			liveVehicleStatus.put("displaydata", vehicle.getDisplayName() + "    [" + driver.getFirstName() +"]");
		} else {
			liveVehicleStatus.put("name", vehicle.getDisplayName() + "\n[" + driver.getFirstName() +"]");
			liveVehicleStatus.put("latestbuttonpressed", ButtonCode.get(dynamicTripStatus.getLatestButtonPressed())+"");
		}
		
		liveVehicleStatus.put("startfuel", 3);
		liveVehicleStatus.put("distance", dynamicTripStatus.getDistance()+"");
		//HardwareModule imeino = LoadHardwareModuleDetails.getInstance().retrieve(vehicle.getImeiId());
		liveVehicleStatus.put("imei", vehicle.getImeiId()+"");
		liveVehicleStatus.put("imeino", imeino.getImei()+"");
		liveVehicleStatus.put("year", vehicle.getModelYear()+"");
		liveVehicleStatus.put("gps", StringUtils.getGPSSS(dynamicTripStatus.getGpsStrength()));
		liveVehicleStatus.put("gsm", StringUtils.getGSMSS(dynamicTripStatus.getGsmStrength()));
		liveVehicleStatus.put("battery", StringUtils.getBatteryStrength(dynamicTripStatus.getBatteryVoltage()));
		long actualTime = DateUtils.adjustToClientTimeInMilliSeconds(localTimeZone, dynamicTripStatus.getLastUpdatedAt());
		//		Live track Vehicle Status Page Update 
		String actualDateTime = DateUtils.adjustToClientTime(localTimeZone, dynamicTripStatus.getLastUpdatedAt());
		long moduleupdatetime = DateUtils.adjustToClientTimeInMilliSeconds(localTimeZone, dynamicTripStatus.getModuleUpdateTime());
		liveVehicleStatus.put("lastupdated", actualDateTime+"");
		liveVehicleStatus.put("timeinmilliseconds", actualTime+"");
		liveVehicleStatus.put("moduleupdatetime", moduleupdatetime+"");

		liveVehicleStatus.put("trip", staticTripDetails.getTripName()+"");
		LOG.debug("Completed processing toMap()");*/
		return liveVehicleStatus;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}
