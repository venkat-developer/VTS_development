package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IUserDao;
import com.harman.its.entity.UserEntity;
import com.harman.its.utils.DataBaseConnection;
import com.harman.its.utils.StringUtils;

/**
 * 
 * @author VAmukapati
 *
 */
public class UserDaoImpl implements IUserDao{
	Logger logger = Logger.getLogger(getClass());

	/**
	 * Authenticating the User Name and password.
	 * @param BusOperator
	 * @return boolean
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public UserEntity authenticateUser(String userName,String password) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		UserEntity userEntity=null;
		try {

			try {
				connection = DataBaseConnection.getInstance().getConnection();
			} catch (ClassNotFoundException e) {
				logger.error("",e);
			}
			if(connection == null){
				logger.error("DB Connection is Null");
				throw new SQLException("DB Connection Null");
			}

			statement = connection.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("select * from users ");
			query.append("where username = '");
			query.append(userName);
			query.append("' and password = '");
			//query.append(StringUtils.md5(password));
			query.append(password);
			query.append("'");
			ResultSet rs = statement.executeQuery(query.toString());
			while (rs.next()) {
				userEntity= new UserEntity(rs.getLong("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getInt("userrole"),
						rs.getBoolean("isactive"));
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
					logger.error("",e);
					throw new SQLException(e);
				}
			}
		}
		return userEntity;
	}
	@Override
	public UserEntity insert(UserEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int update(UserEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UserEntity delete(UserEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserEntity> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void archiveData() {
		// TODO Auto-generated method stub
	}
	/*public UserEntity getUserPasswordEntity(String username) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement statement = null;
		UserEntity userEntity=null;
		try {

			try {
				connection = DataBaseConnection.getInstance().getConnection();
			} catch (ClassNotFoundException e) {
				logger.error("",e);
			}
			if(connection == null){
				logger.error("DB Connection is Null");
				throw new SQLException("DB Connection Null");
			}

			statement = connection.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("select * from users ");
			query.append("where username = '");
			query.append(username);
			query.append("' and isactive ='t'");
			ResultSet rs = statement.executeQuery(query.toString());
			while (rs.next()) {
				userEntity= new UserEntity(rs.getString("username"),rs.getString("password"));
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
					logger.error("",e);
					throw new SQLException(e);
				}
			}
		}
		return userEntity;
	}*/

}