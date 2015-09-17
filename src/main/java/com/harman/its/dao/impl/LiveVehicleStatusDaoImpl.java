package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.apache.log4j.Logger;
import org.postgis.PGgeometry;
import org.springframework.jdbc.core.JdbcTemplate;

import com.harman.its.dao.idao.ILiveVehicleStatusDAO;
import com.harman.its.entity.LiveVehicleStatus;
import com.harman.its.entity.UserEntity;
import com.harman.its.entity.rowmapper.LiveVehicleStatusCacheRowMapper;
import com.harman.its.utils.DataBaseConnection;
import com.harman.its.utils.DateUtils;

@SuppressWarnings("unchecked")
public class LiveVehicleStatusDaoImpl implements ILiveVehicleStatusDAO {

	private static Logger LOG = Logger.getLogger(LiveVehicleStatusDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	

	/*public List<LiveVehicleStatus> fetchLiveVehicleStatusOfUser(long userId) {
		List<LiveVehicleStatus> liveVehicleStatus = null;

		String sql = "select * from livevehiclestatus where tripid in " + "("
				+ "select id from trips where active='t' and vehicleid in "
				+ "(" + "select vehicleid from aclvehicle where userid = "
				+ userId + ")" + ")";
		liveVehicleStatus = (List<LiveVehicleStatus>) jdbcTemplate.query(sql,
				new LiveVehicleStatusRowMapper());

		return liveVehicleStatus;

	}*/

	/*public List<LiveVehicleStatus> selectByTripName(String tripname) {
		String sql = "select * from livevehiclestatus where tripid in(select id from trips where tripname=?) order by lastupdatedat desc limit 1";
		Object[] arg = new Object[]{tripname};
		int[] type = new int[]{Types.VARCHAR};
		return jdbcTemplate.query(sql, arg, type, new LiveVehicleStatusRowMapper());
	}*/

	/*@Override
	public LiveVehicleStatus update(LiveVehicleStatus lvStatus)
			throws OperationNotSupportedException {

		StringBuffer sql = new StringBuffer(); 
		sql.append("UPDATE livevehiclestatus SET vehiclelocation= ");
		sql.append("GeometryFromText('POINT (");
		sql.append(lvStatus.getLocation().getFirstPoint().getX());
		sql.append(" ");
		sql.append(lvStatus.getLocation().getFirstPoint().getY());
		sql.append(")',-1) , gsmstrength = ");
		sql.append(lvStatus.getGsmStrength());
		sql.append(", gpsstrength = ");
		sql.append(lvStatus.getGpsStrength());
		sql.append(", batvolt = ");
		sql.append(lvStatus.getBatteryVoltage());
		sql.append(", distance=");
		sql.append(lvStatus.getDistance());
		sql.append(", maxspeed = "); 
		sql.append(lvStatus.getMaxSpeed());
		sql.append(", cc = ");
		sql.append(lvStatus.isChargerConnected());
		sql.append(", sqd = ");
		sql.append(lvStatus.getSqd());
		sql.append(", sqg = ");
		sql.append(lvStatus.getSqg());
		sql.append(", mrs = ");
		sql.append(lvStatus.getMrs());
		sql.append(", course = ");
		sql.append(lvStatus.getCourse());
		sql.append(", isidle = ");
		sql.append(lvStatus.isIdle());
		sql.append(", fuelad = ");
		sql.append(lvStatus.getFuelAd());
		sql.append(", cumulativedistance = ");
		sql.append(lvStatus.getCumulativeDistance());
		sql.append(", prevsqd = ");
		sql.append(lvStatus.getPrevSqd());
		sql.append(", cid = ");
		sql.append(lvStatus.getCellId());
		sql.append(", lac = ");
		sql.append(lvStatus.getLocationAreaCode());
		sql.append(", geolocation = '");
		sql.append(lvStatus.getLocationString());
		sql.append("', lastupdatedat = '"); 
		sql.append(DateUtils.convertJavaDateToSQLDate(lvStatus.getLastUpdatedAt()));
		sql.append("', rs = ");
		sql.append(lvStatus.getRs());
		sql.append(", moduleupdatetime = '");
		sql.append(DateUtils.convertJavaDateToSQLDate(lvStatus.getModuleUpdateTime()));
		sql.append("', firmwareversion = ");
		sql.append(lvStatus.getFirmwareVersion());
		sql.append(", latestbuttonpressed  = ");
		sql.append(lvStatus.getLatestButtonPressed());
		sql.append(", buttonsequence  = '");
		sql.append(lvStatus.getButtonSequence());
		sql.append("' WHERE tripid = ");
		sql.append(lvStatus.getTripId().getId());

		LOG.debug("LVS Update Query : "+sql.toString());
		
		jdbcTemplate.update(sql.toString());

		return lvStatus;
	}*/

	
	public int updateIsOffRoadStatus(boolean isOffRoad,long vehicleId)	throws OperationNotSupportedException {

		StringBuffer sql = new StringBuffer(); 
		sql.append("UPDATE livevehiclestatus SET ");
		sql.append(" isoffroad  = '");
		sql.append(isOffRoad);
		sql.append("' WHERE tripid in ( select id from trips where vehicleid = "+vehicleId+" )");

		LOG.debug("LVS Update Query : "+sql.toString());
		

		return jdbcTemplate.update(sql.toString());
	}
	
	/**
	 * Retrieving from cache the list of LVSO objects corresponding to keys
	 *//*
	@Override
	public List<LiveVehicleStatus> fetchLiveVehicleStatusByTripIDs(
			List<Long> tripIds) {
		List <LiveVehicleStatus> lvsArray= new ArrayList <LiveVehicleStatus>();
		for (Long tripId : tripIds) {
			LiveVehicleStatus lvs = LoadLiveVehicleStatusRecord.getInstance().retrieveByTripId(tripId);
			if (lvs!=null) {
				lvsArray.add(lvs);
			}
		}	
		return lvsArray;
	}
*/

	/**
	 * Retrieving from cache the LVSO object corresponding to key 
	 */
	/*@Override
	public List<LiveVehicleStatus> selectByPrimaryKey(LongPrimaryKey primaryKey) {
		List <LiveVehicleStatus> lvsArray= new ArrayList <LiveVehicleStatus>();
		LiveVehicleStatus lvs = LoadLiveVehicleStatusRecord.getInstance().retrieveByTripId(primaryKey.getId());
		if (lvs!=null) {
			lvsArray.add(lvs);
		}
		return lvsArray;
	}*/


	/**
	 * Returns the info from cache
	 */
	/*@Override
	public List<LiveVehicleStatus> selectAll() {
		return LoadLiveVehicleStatusRecord.getInstance().retrieveAll();
	}
*/
	/*public String getImeiUsingTripId(long tripId){
		String sql="select * from hardwaremodules where id in((select imeiid from vehicles where id in(select vehicleid from trips where id="+tripId+")))";
		List<HardwareModule> imeiList = jdbcTemplate.query(sql,new HardwareModuleRowMapper());

		String imei = null;
		if(imeiList != null && imeiList.size() > 0)
			imei = imeiList.get(0).getImei();
		return imei;

	}*/

	public LiveVehicleStatus updateFromAlertPacket(LiveVehicleStatus liveVehicleStatus)
			throws OperationNotSupportedException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE livevehiclestatus ");
		sql.append("SET vehiclelocation = ");
		sql.append("GeometryFromText('POINT (");
		sql.append(liveVehicleStatus.getLocation().getFirstPoint().getX());
		sql.append(" ");
		sql.append(liveVehicleStatus.getLocation().getFirstPoint().getY());
		sql.append(")',-1) ");
		sql.append(", lastupdatedat = '");
		sql.append(DateUtils.convertJavaDateToSQLDate(liveVehicleStatus.getLastUpdatedAt()));
		sql.append("', moduleupdatetime = '"+DateUtils.convertJavaDateToSQLDate(liveVehicleStatus.getModuleUpdateTime()));
		sql.append("' WHERE tripid = "+liveVehicleStatus.getTripId().getId());
		LOG.debug("updateFromAlertPacket query is "+sql.toString());
		jdbcTemplate.update(sql.toString());
		return liveVehicleStatus;
	}

	/*public List<LiveVehicleStatus> selectAllForCache() {
		String sql = "select hm.imei, lv.tripid, lv.cumulativedistance, lastupdatedat, lv.moduleupdatetime, gsmstrength, gpsstrength, lv.sqd, lv.sqg,"
				+" 	lv.vehiclelocation, batvolt, lv.isoffroad, cc, maxspeed, v.id as vehicleid, t.speedlimit, t.scheduledtrip, "
				+"  t.tripstartdate, t.enddate, t.driverid, 0 as digital1, 0 as digital2, 0 as pingcounter, 0 as gps_fix_information, v.displayname,"
				+"	lv.latestbuttonpressed, lv.isidle, lv.course "
				+"  from livevehiclestatus lv "
				+"  left join trips t on lv.tripid = t.id "
				+"  left join vehicles v on t.vehicleid= v.id "
				+"  left join hardwaremodules hm on v.imeiid=hm.id  "
				+" where t.active='t' and t.enddate is null";
		return jdbcTemplate.query(sql, new LiveVehicleStatusCacheRowMapper());
	}
*/
	/*public List<LiveVehicleStatus> selectAllForCacheByImei(String imei) {
		String sql = "select hm.imei, lv.tripid, lv.cumulativedistance, lastupdatedat, lv.moduleupdatetime, gsmstrength, gpsstrength, lv.sqd, lv.sqg,"
				+" 	lv.vehiclelocation, batvolt, lv.isoffroad, cc, maxspeed, v.id as vehicleid, t.speedlimit, t.scheduledtrip, "
				+"  t.tripstartdate, t.enddate, t.driverid, 0 as digital1, 0 as digital2, 0 as pingcounter, 0 as gps_fix_information, v.displayname,"
				+"	lv.latestbuttonpressed, lv.isidle, lv.course "
				+"  from livevehiclestatus lv "
				+"  left join trips t on lv.tripid = t.id "
				+"  left join vehicles v on t.vehicleid= v.id "
				+"  left join hardwaremodules hm on v.imeiid=hm.id  "
				+" where t.active='t' and hm.imei='"+imei+"' and t.enddate is null";
		return jdbcTemplate.query(sql, new LiveVehicleStatusCacheRowMapper());
	}*/

	public List<LiveVehicleStatus> fetchLiveVehicleStatusOfUser(Long userId) {
		Connection connection = null;
		Statement statement = null;
		List<LiveVehicleStatus> vehicleStatusCountList = new ArrayList<LiveVehicleStatus>();
		try{
			String sql = "select * from livevehiclestatus where tripid in " + "("
					+ "select id from trips where active='t' and vehicleid in "
					+ "(" + "select vehicleid from aclvehicle where userid = "
					+ userId + ")" + ")";
			
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				PGgeometry geom = (PGgeometry)rs.getObject("vehiclelocation");
				LiveVehicleStatus vehicleStatus = new LiveVehicleStatus(rs.getLong("tripid"),
						geom.getGeometry(),
						rs.getFloat("gsmstrength"),
						rs.getFloat("gpsstrength"),
						rs.getFloat("batvolt"),
						rs.getFloat("distance"),
						rs.getBoolean("cc"),
						rs.getLong("sqd"),
						rs.getLong("sqg"),
						rs.getInt("mrs"),
						rs.getFloat("course"),
						rs.getBoolean("isidle"),
						rs.getFloat("maxspeed"),
						rs.getInt("fuelad"),
						rs.getInt("cdc_counter"),
						rs.getFloat("cumulativedistance"),
						rs.getBoolean("mailsent"),
						rs.getLong("prevsqd"),
						rs.getInt("cid"),
						rs.getInt("lac"),
						rs.getString("geolocation"),
						new Date(rs.getTimestamp("lastupdatedat").getTime()),
						rs.getInt("rs"),
						new Date(rs.getTimestamp("moduleupdatetime").getTime()), 
						rs.getBoolean("isoffroad"));
				vehicleStatusCountList.add(vehicleStatus);
			}
		} catch(Exception e){
			LOG.error("Error while processing offline and online count", e);
		}finally {
			try {
				DataBaseConnection.getInstance().closeStatement(statement);
				DataBaseConnection.getInstance().closeConnection(connection);
			} catch (SQLException e) {
				LOG.error("Error while Closing Database Connection", e);
			}
		}
		
		//int offroadCount = getOffroadCount(userId);
		return vehicleStatusCountList;
	}

	/*public int getOffroadCount(Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*)  from livevehiclestatus where tripid in (select id from trips where vehicleid ");
		sql.append("in (select id from vehicles where vehicleid in (select vehicleid from aclvehicle where userid=");
		sql.append(userId);
		sql.append(")  and deleted='f')) and isoffroad is true;");
		return jdbcTemplate.queryForInt(sql.toString());
	}*/
	
	public List<LiveVehicleStatus> selectAllForCacheByVehicleId(Long vehicleId) {
		String sql = "select hm.imei, lv.tripid, lv.cumulativedistance, lastupdatedat, lv.moduleupdatetime, gsmstrength, gpsstrength, lv.sqd, lv.sqg,"
				+" 	lv.vehiclelocation, batvolt, lv.isoffroad, cc, maxspeed, v.id as vehicleid, t.speedlimit, t.scheduledtrip, "
				+"  t.tripstartdate, t.enddate, t.driverid, 0 as digital1, 0 as digital2, 0 as pingcounter, 0 as gps_fix_information, v.displayname,"
				+"	lv.latestbuttonpressed, lv.isidle, lv.course "
				+"  from livevehiclestatus lv "
				+"  left join trips t on lv.tripid = t.id "
				+"  left join vehicles v on t.vehicleid= v.id "
				+"  left join hardwaremodules hm on v.imeiid=hm.id  "
				+" where t.active='t' and v.id="+vehicleId+" and t.enddate is null";
		return jdbcTemplate.query(sql, new LiveVehicleStatusCacheRowMapper());
	}

	
	public List<LiveVehicleStatus> selectAllForCacheByDriverId(Long driverId) {
		String sql = "select hm.imei, lv.tripid, lv.cumulativedistance, lastupdatedat, lv.moduleupdatetime, gsmstrength, gpsstrength, lv.sqd, lv.sqg,"
				+" 	lv.vehiclelocation, batvolt, lv.isoffroad, cc, maxspeed, v.id as vehicleid, t.speedlimit, t.scheduledtrip, "
				+"  t.tripstartdate, t.enddate, t.driverid, 0 as digital1, 0 as digital2, 0 as pingcounter, 0 as gps_fix_information, v.displayname,"
				+"	lv.latestbuttonpressed, lv.isidle, lv.course "
				+"  from livevehiclestatus lv "
				+"  left join trips t on lv.tripid = t.id "
				+"  left join vehicles v on t.vehicleid= v.id "
				+"  left join hardwaremodules hm on v.imeiid=hm.id  "
				+" where t.active='t' and t.driverid="+driverId+" and t.enddate is null";
		return jdbcTemplate.query(sql, new LiveVehicleStatusCacheRowMapper());
	}

	
	public LiveVehicleStatus getLiveDataByTripId(Long tripId) {
		Connection connection = null;
		Statement statement = null;
		try{
		String sql = "select hm.imei, lv.tripid, lv.cumulativedistance, lastupdatedat, lv.moduleupdatetime, gsmstrength, gpsstrength, lv.sqd, lv.sqg,"
				+" 	lv.vehiclelocation, batvolt, lv.isoffroad, cc, maxspeed, v.id as vehicleid, t.speedlimit, t.scheduledtrip, "
				+"  t.tripstartdate, t.enddate, t.driverid, 0 as digital1, 0 as digital2, 0 as pingcounter, 0 as gps_fix_information, v.displayname,"
				+"	lv.latestbuttonpressed, lv.isidle, lv.course "
				+"  from livevehiclestatus lv "
				+"  left join trips t on lv.tripid = t.id "
				+"  left join vehicles v on t.vehicleid= v.id "
				+"  left join hardwaremodules hm on v.imeiid=hm.id  "
				+" where t.active='t' and t.id="+tripId+" and t.enddate is null";
		connection = DataBaseConnection.getInstance().getConnection();
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()){
			LiveVehicleStatus liveVehicleObject = new LiveVehicleStatus();
			
			liveVehicleObject.setTripId(rs.getLong("tripid"));
			liveVehicleObject.setImei(rs.getString("imei"));
			liveVehicleObject.setCumulativeDistance(rs.getFloat("cumulativedistance"));
			liveVehicleObject.setLastUpdatedAt(new Date(rs.getTimestamp("lastupdatedat").getTime()));
			liveVehicleObject.setGsmStrength(rs.getFloat("gsmstrength"));
			liveVehicleObject.setGpsStrength(rs.getFloat("gpsstrength"));
			liveVehicleObject.setSqd(rs.getLong("sqd"));
			liveVehicleObject.setPrevSqd(rs.getLong("sqd"));
			liveVehicleObject.setSqg(rs.getLong("sqg"));
			liveVehicleObject.setBatteryVoltage(rs.getFloat("batvolt"));
			liveVehicleObject.setOffroad(rs.getBoolean("isoffroad"));
			liveVehicleObject.setChargerConnected(rs.getBoolean("cc"));
			liveVehicleObject.setMaxSpeed(rs.getFloat("maxspeed"));
			liveVehicleObject.setVehicleId(rs.getLong("vehicleid"));
			liveVehicleObject.setDriverId(rs.getLong("driverid"));
			liveVehicleObject.setSpeedLimit(rs.getDouble("speedlimit"));
			liveVehicleObject.setScheduleTrip(rs.getBoolean("scheduledtrip"));
			liveVehicleObject.setTripStartDate(rs.getDate("tripstartdate"));
			liveVehicleObject.setTripEndDate(rs.getDate("enddate"));
			liveVehicleObject.setDigital1(rs.getBoolean("digital1"));
			liveVehicleObject.setDigital2(rs.getBoolean("digital2"));
			liveVehicleObject.setGps_fix_information(rs.getInt("gps_fix_information"));
			liveVehicleObject.setModuleUpdateTime(new Date(rs.getTimestamp("moduleupdatetime").getTime()));
			PGgeometry geom = (PGgeometry)rs.getObject("vehiclelocation");
			liveVehicleObject.setLocation(geom.getGeometry());
			liveVehicleObject.setLatestButtonPressed(rs.getInt("latestbuttonpressed"));
			liveVehicleObject.setIdle(rs.getBoolean("isidle"));
			liveVehicleObject.setCourse(rs.getFloat("course"));
			return liveVehicleObject;
		}
		}catch(Exception exception){
			LOG.error("Error while loading live data", exception);
		}finally {
			try {
				DataBaseConnection.getInstance().closeStatement(statement);
				DataBaseConnection.getInstance().closeConnection(connection);
			} catch (SQLException e) {
				LOG.error("Error while Closing Database Connection", e);
			}
		}
		return null;
	}

	@Override
	public UserEntity insert(UserEntity entity) throws SQLException,
			ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(UserEntity entity) throws ClassNotFoundException,
			SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserEntity delete(UserEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEntity authenticateUser(String userName, String password)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> selectAll() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}