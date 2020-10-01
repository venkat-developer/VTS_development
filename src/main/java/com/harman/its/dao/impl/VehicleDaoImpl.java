package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
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

	/**
	 * Authenticating the User Name and password.
	 * 
	 * @param BusOperator
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public UserEntity authenticateUser(String userName, String password) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		UserEntity userEntity = null;
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
			query.append("select * from users ");
			query.append("where user_name = '");
			query.append(userName);
			query.append("' and user_password = '");
			// query.append(StringUtils.md5(password));
			query.append(password);
			query.append("'");
			ResultSet rs = statement.executeQuery(query.toString());
			while (rs.next()) {
				userEntity = new UserEntity(rs.getLong("user_id"), rs.getString("user_name"),
						rs.getString("user_password"), rs.getString("first_name"),rs.getString("last_name"),rs.getInt("user_role"), rs.getBoolean("isActive"),
						rs.getString("travels_name"), rs.getString("email"), rs.getString("mobile_number"),
						rs.getString("address"), rs.getString("contact_person"), rs.getInt("subscription_type"),
						rs.getString("website"), rs.getDate("registration_date"));
			}
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
		return userEntity;
	}

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

//	public Vehicle insert(Vehicle vehicleEntity) throws SQLException, ClassNotFoundException, ParseException {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		Statement statement = null;
//		try {
//			try {
//				connection = DataBaseConnection.getInstance().getConnection();
//			} catch (ClassNotFoundException e) {
//				logger.error("", e);
//			}
//			if (connection == null) {
//				logger.error("DB Connection is Null");
//				throw new SQLException("DB Connection Null");
//			}
//
//			statement = connection.createStatement();
//			StringBuilder query = new StringBuilder();
//			query.append(
//					"insert into users(user_name,user_password,first_name,last_name,user_role,travels_name,email,mobile_number,address,");
//			query.append("contact_person,subscription_type,website,isActive)");
//			query.append("values ('");
//			query.append(userEntity.getLogin());
//			query.append("','");
//			query.append(userEntity.getPassword());
//			query.append("','");
//			query.append(userEntity.getFirstName());
//			query.append("','");
//			query.append(userEntity.getLastName());
//			query.append("',");
//			query.append(userEntity.getRole());
//			query.append(",'");
//			query.append(userEntity.getCompanyName());
//			query.append("','");
//			query.append(userEntity.getEmail());
//			query.append("','");
//			query.append(userEntity.getMobileNumber());
//			query.append("','");
//			query.append(userEntity.getAddress());
//			query.append("','");
//			query.append(userEntity.getContactPerson());
//			query.append("',");
//			query.append(userEntity.getSubscription_type());
//			query.append(",'");
//			query.append(userEntity.getWebsite());
//			query.append("',");
//			query.append(userEntity.getIsActive());
//			query.append(")");
//			statement.executeUpdate(query.toString());
//		} catch (SQLException e) {
//			logger.error("" + e);
//			throw new SQLException(e);
//		} finally {
//			if (statement != null) {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					throw new SQLException(e);
//				}
//			}
//			if (connection != null) {
//				try {
//					DataBaseConnection.getInstance().closeConnection(connection);
//				} catch (SQLException e) {
//					logger.error("", e);
//					throw new SQLException(e);
//				}
//			}
//		}
//		return userEntity;
//	}

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