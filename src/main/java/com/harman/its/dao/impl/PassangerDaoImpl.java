package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IPassangerDao;
import com.harman.its.entity.LongPrimaryKey;
import com.harman.its.entity.Passenger;
import com.harman.its.utils.DataBaseConnection;

/**
 * 
 * @author VAmukapati
 *
 */
public class PassangerDaoImpl implements IPassangerDao {
	Logger logger = Logger.getLogger(getClass());

	public Passenger insert(Passenger paxEntity) throws SQLException, ClassNotFoundException, ParseException {

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
			query.append("insert into passenger(user_id,firstname,lastname,email,mobile_number,address,passanger_type,vendor_id) ");
			query.append("values (");
			query.append(paxEntity.getUserId());
			query.append(",'");
			query.append(paxEntity.getFirstName());
			query.append("','");
			query.append(paxEntity.getLastName());
			query.append("','");
			query.append(paxEntity.getEmail());
			query.append("','");
			query.append(paxEntity.getMobile());
			query.append("','");
			query.append(paxEntity.getAddress());
			query.append("',");
			query.append(paxEntity.getPassengerType());
			query.append(",");
			query.append(paxEntity.getVendorId());
			query.append(")");
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
		return paxEntity;
	
	}

	public int update(Passenger entity) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Passenger delete(Passenger entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Passenger> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<Passenger> selectAllByUserID(long userId) throws SQLException, ClassNotFoundException, ParseException {


		Connection connection = null;
		Statement statement = null;
		List<Passenger> passangerEntityList = new ArrayList<Passenger>();
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
			query.append("select * from passenger where user_id=" + userId);
			System.out.println("Query is >> " + query.toString());
			ResultSet rs = statement.executeQuery(query.toString());
			while (rs.next()) {
				Passenger passanger = new Passenger(new LongPrimaryKey(rs.getLong("passanger_id")), rs.getLong("user_id"),
						rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
						rs.getString("mobile_number"), rs.getString("address"),rs.getInt("passanger_type"),rs.getInt("vendor_id"));
				passangerEntityList.add(passanger);
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
		return passangerEntityList;

	
	
	}

	
}