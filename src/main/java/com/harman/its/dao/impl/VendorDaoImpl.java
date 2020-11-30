package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IVendorDao;
import com.harman.its.entity.LongPrimaryKey;
import com.harman.its.entity.Vendor;
import com.harman.its.utils.DataBaseConnection;

/**
 * 
 * @author VAmukapati
 *
 */
public class VendorDaoImpl implements IVendorDao {
	Logger logger = Logger.getLogger(getClass());

	public Vendor insert(Vendor vendorEntity) throws SQLException, ClassNotFoundException, ParseException {
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
			query.append(
					"insert into vendor(user_id,firstname,lastname,email,mobile_number,fax_number,website,address,contact_person) ");
			query.append("values (");
			query.append(vendorEntity.getUserId());
			query.append(",'");
			query.append(vendorEntity.getFirstName());
			query.append("','");
			query.append(vendorEntity.getLastName());
			query.append("','");
			query.append(vendorEntity.getEmail());
			query.append("','");
			query.append(vendorEntity.getMobileNumber());
			query.append("','");
			query.append(vendorEntity.getFaxNumber());
			query.append("','");
			query.append(vendorEntity.getWebsite());
			query.append("','");
			query.append(vendorEntity.getAddress());
			query.append("','");
			query.append(vendorEntity.getContactPerson());
			query.append("')");
			System.out.println("Query is >> " + query.toString());
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
		return vendorEntity;

	}

	public List<Vendor> selectAllByUserId(long userId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Vendor> vendorList = new ArrayList<Vendor>();
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
			query.append("select * from vendor where user_id =");
			query.append(userId);
			System.out.println("Query is >> " + query.toString());
			ResultSet rs = statement.executeQuery(query.toString());
			while (rs.next()) {
				Vendor vendorEntity = new Vendor(
						new LongPrimaryKey(rs.getLong("vendor_id")), 
						rs.getLong("user_id"),
						rs.getString("firstname"), 
						rs.getString("lastname"), 
						rs.getString("email"),
						rs.getString("website"), 
						rs.getString("mobile_number"), 
						rs.getString("fax_number"),
						rs.getString("address"), 
						rs.getString("contact_person"));
				vendorList.add(vendorEntity);
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
		return vendorList;
	}

	public int update(Vendor entity) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Vendor delete(Vendor entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Vendor> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}
}