package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.postgis.PGgeometry;

import com.harman.its.dao.idao.ITrackHistoryDao;
import com.harman.its.entity.LongPrimaryKey;
import com.harman.its.entity.TrackHistoryEntity;
import com.harman.its.entity.VehicleSatsEntity;
import com.harman.its.utils.DataBaseConnection;

public class TrackHistoryDaoImpl implements ITrackHistoryDao{

	Logger logger = Logger.getLogger(getClass());
	@Override
	public TrackHistoryEntity insert(TrackHistoryEntity entity)
			throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TrackHistoryEntity entity) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TrackHistoryEntity delete(TrackHistoryEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrackHistoryEntity> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TrackHistoryEntity> selectByTripId(long tripId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TrackHistoryEntity> selectBetweenDates(long vehicleId, Date startDate, Date endDate) throws ClassNotFoundException, SQLException {

		Connection connection = null;
		Statement statement = null;
		List<TrackHistoryEntity> tripsList = new ArrayList<TrackHistoryEntity>();
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select *  from trackhistory where tripid in(select id from trips where vehicleid=");
			sql.append(vehicleId);
			sql.append(" ) and occurredat>='");
			sql.append("2000-10-02 00:00:00");
			sql.append("' and occurredat<='");
			sql.append("2015-10-02 00:00:00");
			sql.append("' order by occurredat");
			logger.debug("Query is "+sql.toString());
			ResultSet rs = statement.executeQuery(sql.toString());
			while(rs.next()){
				PGgeometry geom= (PGgeometry)rs.getObject("location");
				TrackHistoryEntity tHistory = new TrackHistoryEntity(new LongPrimaryKey(rs.getLong("id")),
						rs.getLong("tripid"),
						rs.getFloat("gpssignal"),
						rs.getFloat("gsmsignal"),
						rs.getFloat("direction"),
						rs.getLong("sqd"),
						rs.getLong("sqg"),
						rs.getFloat("batteryvoltage"),
						rs.getFloat("cd"),
						rs.getFloat("speed"),
						rs.getInt("analogue1"),
						rs.getInt("analogue2"),
						rs.getInt("error"),
						rs.getLong("lac"),
						rs.getLong("cid"),
						rs.getBoolean("isping"),
						rs.getBoolean("ismrs"),
						rs.getBoolean("ischargerconnected"),
						rs.getBoolean("isrestart"),
						rs.getBoolean("digital1"),
						rs.getBoolean("digital2"),
						rs.getBoolean("digital3"),
						rs.getBoolean("ispanic"),

						new Date(rs.getTimestamp("occurredat").getTime()),
						geom.getGeometry(),

						rs.getFloat("fuel"),
						rs.getFloat("distance"),
						rs.getLong("pingcounter"),
						rs.getInt("gps_fix_information")
						);
				tripsList.add(tHistory);
			}
			return tripsList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
			if (connection != null) {
				try {
					DataBaseConnection.getInstance().closeConnection(connection);
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}

		}
	}
	
	public List<TrackHistoryEntity> selectBetweenDatesIntervalNotZero(long vehicleId, Date startDate, Date endDate,int interval) throws ClassNotFoundException, SQLException {

		Connection connection = null;
		Statement statement = null;
		List<TrackHistoryEntity> tripsList = new ArrayList<TrackHistoryEntity>();
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select *  from trackhistory where tripid in(select id from trips where vehicleid=");
			sql.append(vehicleId);
			sql.append(" ) and occurredat>='");
			sql.append("2000-10-02 00:00:00");
			sql.append("' and occurredat<='");
			sql.append("2015-10-02 00:00:00");
			sql.append("and MOD(extract(epoch from (t.occurredat::timestamp - ");
			sql.append("2000-10-02 00:00:00");
			sql.append("' ::timestamp))::int,");
			sql.append(interval);
			sql.append(")=0 order by occurredat");
			logger.debug("Query is "+sql.toString());
			ResultSet rs = statement.executeQuery(sql.toString());
			while(rs.next()){
				PGgeometry geom= (PGgeometry)rs.getObject("location");
				TrackHistoryEntity tHistory = new TrackHistoryEntity(new LongPrimaryKey(rs.getLong("id")),
						rs.getLong("tripid"),
						rs.getFloat("gpssignal"),
						rs.getFloat("gsmsignal"),
						rs.getFloat("direction"),
						rs.getLong("sqd"),
						rs.getLong("sqg"),
						rs.getFloat("batteryvoltage"),
						rs.getFloat("cd"),
						rs.getFloat("speed"),
						rs.getInt("analogue1"),
						rs.getInt("analogue2"),
						rs.getInt("error"),
						rs.getLong("lac"),
						rs.getLong("cid"),
						rs.getBoolean("isping"),
						rs.getBoolean("ismrs"),
						rs.getBoolean("ischargerconnected"),
						rs.getBoolean("isrestart"),
						rs.getBoolean("digital1"),
						rs.getBoolean("digital2"),
						rs.getBoolean("digital3"),
						rs.getBoolean("ispanic"),

						new Date(rs.getTimestamp("occurredat").getTime()),
						geom.getGeometry(),

						rs.getFloat("fuel"),
						rs.getFloat("distance"),
						rs.getLong("pingcounter"),
						rs.getInt("gps_fix_information")
						);
				tripsList.add(tHistory);
			}
			return tripsList;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
			if (connection != null) {
				try {
					DataBaseConnection.getInstance().closeConnection(connection);
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}

		}
	}
	
	public VehicleSatsEntity getAvgAndMaxSpeedAndCumulativeDistanceForVehicle(Long vehicleId, Date startDate, Date endDate) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		VehicleSatsEntity stVehicleSatsEntity = null;
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select max(speed),avg(speed),sum(distance) from trackhistory where trackhistory.tripid in");
			sql.append(" (select id from trips where trips.vehicleid=");
			sql.append(vehicleId);
			sql.append(") and occurredat>'");
			sql.append("2000-10-02 00:00:00");
			sql.append("' and occurredat<='");
			sql.append("2015-10-02 00:00:00");
			sql.append("'");
			logger.debug("Query is "+sql.toString());
			ResultSet rs = statement.executeQuery(sql.toString());
			while(rs.next()){
				stVehicleSatsEntity = new VehicleSatsEntity();
				stVehicleSatsEntity.setSpeed(rs.getDouble("max"));
				stVehicleSatsEntity.setAvgspeed(rs.getDouble("avg"));
				stVehicleSatsEntity.setDistance(rs.getDouble("sum"));
			}
			return stVehicleSatsEntity;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
			if (connection != null) {
				try {
					DataBaseConnection.getInstance().closeConnection(connection);
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}

		}
	}
/*	public List<TrackHistory> selectBetweenDatesFroZeroInterval(long vehicleId, Date startDate, Date endDate) {

		Connection connection = null;
		Statement statement = null;
		VehicleSatsEntity stVehicleSatsEntity = null;
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select *  from trackhistory where tripid in(select id from trips where vehicleid=?) and occurredat>=?");
			sql.append(" and occurredat<=? order by occurredat limit 15 ;");
			logger.debug("Query is "+sql.toString());
			ResultSet rs = statement.executeQuery(sql.toString());
			while(rs.next()){
				stVehicleSatsEntity = new VehicleSatsEntity();
				stVehicleSatsEntity.setSpeed(rs.getDouble("max"));
				stVehicleSatsEntity.setAvgspeed(rs.getDouble("avg"));
				stVehicleSatsEntity.setDistance(rs.getDouble("sum"));
			}
			return stVehicleSatsEntity;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
			if (connection != null) {
				try {
					DataBaseConnection.getInstance().closeConnection(connection);
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}

		}
		Object[] arg = new Object[] { vehicleId, new Timestamp(startDate.getTime()), new Timestamp(endDate.getTime())};
		int[] type = new int[] { Types.BIGINT, Types.TIMESTAMP, Types.TIMESTAMP };
		List<TrackHistory> result = jdbcTemplate.query(sql.toString(), arg, type, new TrackHistoryRowMapper());
		if(result == null){
			return new ArrayList<TrackHistory>();
		}
		return result;
	}*/
}
