package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IVehicleDao;
import com.harman.its.entity.UserEntity;
import com.harman.its.entity.Vehicle;
import com.harman.its.utils.DataBaseConnection;

/**
 * 
 * @author VAmukapati
 *
 */
public class VehicleDaoImpl implements IVehicleDao {
	Logger logger = Logger.getLogger(getClass());

	public int update(UserEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserEntity delete(UserEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Vehicle> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void archiveData() {
		// TODO Auto-generated method stub
	}

	public Vehicle insert(Vehicle vehicleEntity) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			try {
				connection = DataBaseConnection.getInstance().getConnection();
			} catch (ClassNotFoundException e) {
				logger.error("", e);
			}
			if (connection == null) {
				logger.error("DB Connection is Null");
				throw new SQLException("DB Connection Null");
			}
			statement = connection.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("insert into vehicle(registration_num,vehicle_type,user_id,vehicleMake,vehicleModel,isACVehicle,insurance_validity) ");
			query.append("values ('");
			query.append(vehicleEntity.getRegistrationNo());
			query.append("',");
			query.append(vehicleEntity.getVehicleType());
			query.append(",");
			query.append(vehicleEntity.getUserId());
			query.append(",'");
			query.append(vehicleEntity.getVehicleMake());
			query.append("','");
			query.append(vehicleEntity.getVehicleModel());
			query.append("',");
			query.append(vehicleEntity.isACVehicle());
			query.append(",'");
			java.util.Date date=new java.util.Date();
			query.append(new java.sql.Date(date.getTime()));
			query.append("')");
			System.out.println("Query is >> "+query.toString());
			statement.executeUpdate(query.toString());
		} catch (SQLException e) {
			logger.error("" + e);
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
					logger.error("", e);
					throw new SQLException(e);
				}
			}
		}
		return vehicleEntity;
	}

	public int update(Vehicle entity) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Vehicle delete(Vehicle entity) {
		// TODO Auto-generated method stub
		return null;
	}

}