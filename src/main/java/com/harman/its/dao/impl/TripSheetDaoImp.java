package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.harman.its.dao.idao.ITripSheetDao;
import com.harman.its.entity.TripSheet;
import com.harman.its.utils.DataBaseConnection;


public class TripSheetDaoImp implements ITripSheetDao{

	public TripSheet insert(TripSheet entity) throws SQLException,
	ClassNotFoundException, ParseException {

		Connection connection = null;
		Statement statement = null;
		List<TripSheet> tripsList = new ArrayList<TripSheet>();
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuilder sideASQl = new StringBuilder();
			sideASQl.append("NSERT INTO Customers (trip_sheet_number, vehicle_id, driver_id, user_id, trip_type, passanger_name,refferedby,"+
							"trip_start_date,trip_end_date,tax,driverBeta,grandTotal,startKm,endKM,ac_trip)" +"VALUES ("+entity.getTripSheetNumber()+","+
							entity.getVehicleId()+","+entity.getDriverId()+","+entity.getUserID()+","+entity.getTripType()+","+entity.getPassangerName()+","+
							entity.getRefferedBy()+","+entity.getTripStartDate()+","+entity.getTripEndDate()+","+entity.getTax()+","+entity.getDriverBeta()+","+
							entity.getGrandTotal()+","+entity.getStartKm()+","+entity.getEndKM()+","+entity.isACTrip()+")");
			ResultSet rs = statement.executeQuery(sideASQl.toString());
			while(rs.next()){
				TripSheet trip = new TripSheet(
						rs.getLong("id"),
						rs.getInt("trip_sheet_number"),
						rs.getInt("vehicle_id"),
						rs.getInt("driver_id"),
						rs.getInt("user_id"),
						rs.getInt("trip_type"),
						rs.getString("passanger_name"),
						rs.getString("refferedby"),
						rs.getDate("trip_start_date"),
						rs.getDate("trip_end_date"),
						rs.getDouble("tax"),
						rs.getDouble("driverBeta"),
						rs.getDouble("grandTotal"),
						rs.getLong("startKm"),
						rs.getLong("endKM"),
						rs.getBoolean("ac_trip"));
				tripsList.add(trip);
			}
			return entity;
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

	public int update(TripSheet entity) throws ClassNotFoundException,
	SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	public TripSheet delete(TripSheet entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TripSheet> selectAll() throws SQLException,
	ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		List<TripSheet> tripsList = new ArrayList<TripSheet>();
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuilder sideASQl = new StringBuilder();
			sideASQl.append("select * from trip_sheet");
			ResultSet rs = statement.executeQuery(sideASQl.toString());
			while(rs.next()){
				TripSheet trip = new TripSheet(
						rs.getLong("id"),
						rs.getInt("trip_sheet_number"),
						rs.getInt("vehicle_id"),
						rs.getInt("driver_id"),
						rs.getInt("user_id"),
						rs.getInt("trip_type"),
						rs.getString("passanger_name"),
						rs.getString("refferedby"),
						rs.getDate("tripstartdate"),
						rs.getDate("tripstartdate"),
						rs.getDouble("tax"),
						rs.getDouble("driverBeta"),
						rs.getDouble("grandTotal"),
						rs.getLong("startKm"),
						rs.getLong("endKM"),
						rs.getBoolean("ac_trip"));
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
	
	public List<TripSheet> selectTripsByUserId(long userId) throws SQLException,
	ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		List<TripSheet> tripsList = new ArrayList<TripSheet>();
		try {
			String sql =  "select * from trip_sheet t where userid = "+ userId;
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				TripSheet trip = new TripSheet(
						rs.getLong("id"),
						rs.getInt("trip_sheet_number"),
						rs.getInt("vehicle_id"),
						rs.getInt("driver_id"),
						rs.getInt("user_id"),
						rs.getInt("trip_type"),
						rs.getString("passanger_name"),
						rs.getString("refferedby"),
						rs.getDate("tripstartdate"),
						rs.getDate("tripstartdate"),
						rs.getDouble("tax"),
						rs.getDouble("driverBeta"),
						rs.getDouble("grandTotal"),
						rs.getLong("startKm"),
						rs.getLong("endKM"),
						rs.getBoolean("ac_trip"));
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
	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

}
