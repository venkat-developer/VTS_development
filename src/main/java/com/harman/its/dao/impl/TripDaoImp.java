package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.harman.its.dao.idao.ITripsDao;
import com.harman.its.entity.TripsEntity;
import com.harman.its.utils.DataBaseConnection;


public class TripDaoImp implements ITripsDao{

	@Override
	public TripsEntity insert(TripsEntity entity) throws SQLException,
	ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TripsEntity entity) throws ClassNotFoundException,
	SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TripsEntity delete(TripsEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripsEntity> selectAll() throws SQLException,
	ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		List<TripsEntity> tripsList = new ArrayList<TripsEntity>();
		try {
			//String sql =  "select * from trips t where t.active = true and t.vehicleid in (select a.vehicleid from aclvehicle a where a.userid = "+ userId+")";
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuilder sideASQl = new StringBuilder();
			sideASQl.append("select * from trips");
			ResultSet rs = statement.executeQuery(sideASQl.toString());
			while(rs.next()){
				TripsEntity trip = new TripsEntity(rs.getLong("id"),
				rs.getString("tripname"),
				rs.getDate("tripstartdate"),
				rs.getBoolean("overridefuelcalibration"),
				rs.getFloat("speedlimit"),
				rs.getLong("vehicleid"),
				rs.getLong("driverid"),
				rs.getString("destination"),
				rs.getBoolean("scheduledtrip"),
				rs.getDate("enddate"),
				rs.getBoolean("active"),
				rs.getLong("cumulativedistance"),
				rs.getLong("geofencerefid"),
				rs.getBoolean("mail_sent"),
				rs.getInt("start_ad"),
				rs.getInt("idlepointstimelimit"));
				tripsList.add(trip);
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
	
	public List<TripsEntity> selectTripsByUserId(long userId) throws SQLException,
	ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		List<TripsEntity> tripsList = new ArrayList<TripsEntity>();
		try {
			String sql =  "select * from trips t where t.active = true and t.vehicleid in (select a.vehicleid from aclvehicle a where a.userid = "+ userId+")";
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				TripsEntity trip = new TripsEntity(rs.getLong("id"),
						rs.getString("tripname"),
						rs.getDate("tripstartdate"),
						rs.getBoolean("overridefuelcalibration"),
						rs.getFloat("speedlimit"),
						rs.getLong("vehicleid"),
						rs.getLong("driverid"),
						rs.getString("destination"),
						rs.getBoolean("scheduledtrip"),
						rs.getDate("enddate"),
						rs.getBoolean("active"),
						rs.getLong("cumulativedistance"),
						rs.getLong("geofencerefid"),
						rs.getBoolean("mail_sent"),
						rs.getInt("start_ad"),
						rs.getInt("idlepointstimelimit"));
				tripsList.add(trip);
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

	@Override
	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

}
