package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IDriverDao;
import com.harman.its.entity.Driver;
import com.harman.its.utils.DataBaseConnection;

/**
 * 
 * @author VAmukapati
 *
 */
public class DriverDaoImpl implements IDriverDao {
	Logger logger = Logger.getLogger(getClass());

	public Driver insert(Driver driverEntity) throws SQLException, ClassNotFoundException, ParseException {

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
			query.append("insert into driver(user_id,firstname,lastname,licence_number,email,mobile_number) ");
			query.append("values (");
			query.append(driverEntity.getUserId());
			query.append(",'");
			query.append(driverEntity.getFirstName());
			query.append("','");
			query.append(driverEntity.getLastName());
			query.append("','");
			query.append(driverEntity.getLicenseNo());
			query.append("','");
			query.append(driverEntity.getEmail());
			query.append("','");
			query.append(driverEntity.getMobileNumber());
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
		return driverEntity;
	
	}

	public int update(Driver entity) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Driver delete(Driver entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Driver> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
}