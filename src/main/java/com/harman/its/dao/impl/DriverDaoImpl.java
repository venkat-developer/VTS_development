package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IDriverDao;
import com.harman.its.entity.Driver;
import com.harman.its.utils.DataBaseConnection;



public class DriverDaoImpl implements IDriverDao{
	Logger logger = Logger.getLogger(getClass());

		@Override
	public Driver selectByDriverId(long driverId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			String sql = "select * from drivers where id = " +driverId;
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Driver newDriver = new Driver(rs.getLong("id"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("licenseno"),
						rs.getString("photo"),
						rs.getLong("groupid"),
						rs.getBoolean("deleted"));
				return newDriver;
				
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

		@Override
		public Driver insert(Driver entity) throws SQLException, ClassNotFoundException, ParseException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int update(Driver entity) throws ClassNotFoundException, SQLException, ParseException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Driver delete(Driver entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Driver> selectAll() throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void archiveData() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			
		}
}