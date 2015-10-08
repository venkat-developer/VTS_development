package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IVehicleDao;
import com.harman.its.entity.LongPrimaryKey;
import com.harman.its.entity.Vehicle;
import com.harman.its.utils.DataBaseConnection;



public class VehicleDaoImpl implements IVehicleDao{
	Logger logger = Logger.getLogger(getClass());

	@Override
	public Vehicle insert(Vehicle entity) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Vehicle entity) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vehicle delete(Vehicle entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehicle selectByVehicleId(long vehicleId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
			//String sql =  "select * from trips t where t.active = true and t.vehicleid in (select a.vehicleid from aclvehicle a where a.userid = "+ userId+")";
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			String sql = "select * from vehicles where id = " + vehicleId;
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Vehicle vehicle = new Vehicle(new LongPrimaryKey(rs.getLong("id")),
											  rs.getString("displayname"),
											  rs.getString("make"),
											  rs.getString("model"),
											  rs.getString("year"),
											  rs.getLong("imeiid"),
											  rs.getDate("odometer_updatedat"),
											  rs.getInt("odometer_value"),
											  rs.getLong("fuelcaliberationid"),
											  rs.getInt("vehicle_icon_pic_id"),
											  rs.getLong("groupid"),
											  rs.getBoolean("deleted"),
											  rs.getString("type"));
				return vehicle;
			}
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
		return null;
	}
	public List<Vehicle> selectByUserId(long userId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from vehicles where deleted = false and id in ");
			sql.append("( select vehicleid from aclvehicle where userid in ( select id from users where owner_id =");
			sql.append(userId);
			sql.append("or id =");
			sql.append(userId);
			sql.append("))");
			logger.debug("Query : "+sql.toString());
			ResultSet rs = statement.executeQuery(sql.toString());
			while(rs.next()){
				Vehicle vehicle = new Vehicle(new LongPrimaryKey(rs.getLong("id")),
											  rs.getString("displayname"),
											  rs.getString("make"),
											  rs.getString("model"),
											  rs.getString("year"),
											  rs.getLong("imeiid"),
											  rs.getDate("odometer_updatedat"),
											  rs.getInt("odometer_value"),
											  rs.getLong("fuelcaliberationid"),
											  rs.getInt("vehicle_icon_pic_id"),
											  rs.getLong("groupid"),
											  rs.getBoolean("deleted"),
											  rs.getString("type"));
				vehiclesList.add(vehicle);
			}
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
		return vehiclesList;
	}
}