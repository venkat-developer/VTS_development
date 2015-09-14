package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.IIncrementerDao;
import com.harman.its.entity.IncrementerEntity;
import com.harman.its.utils.DataBaseConnection;

public class IncrementerDaoImpl implements IIncrementerDao{
	Logger logger = Logger.getLogger(getClass());

	/**
	 * Get the latest Id from incrementer. 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public int getLatestIdByType(int type) throws ClassNotFoundException, SQLException{
		Date now=new Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		logger.info("Current date for FILE_INC "+sqlDate);
		int incementId=0;
		Connection connection = null;
		Statement statement = null;
		try{
			try {
				connection = DataBaseConnection.getInstance().getConnection();
			} catch (ClassNotFoundException e) {
				logger.error("", e);
			} catch (SQLException e) {
				logger.error("", e);
			}
			if(connection != null){
				statement = connection.createStatement();
				StringBuilder query = new StringBuilder();
				query.append("select * from incrementer where ");
				query.append(" currentdate = '");
				query.append(sqlDate);
				query.append("' and type=");
				query.append(type);
				logger.debug("Select query is "+query.toString());
				ResultSet rs = statement.executeQuery(query.toString());
				while(rs.next()){
					incementId= rs.getInt("value");
				}

			}
		} catch(SQLException e){
			logger.error("", e);
		} finally{
			try {
				DataBaseConnection.getInstance().closeConnection(connection);
			} catch (SQLException e) {
				logger.error("",e);
			}
		}	
		return ++incementId;
	}

	/**
	 * 
	 * @param FILE_INC
	 * @param requestType
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public IncrementerEntity insert(IncrementerEntity entity) throws ClassNotFoundException, SQLException {
		logger.info("inserting the new date value in the db");
		Date now=new Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		Connection connection = null;
		try{
			try {
				connection = DataBaseConnection.getInstance().getConnection();
			} catch (ClassNotFoundException e) {
				logger.error("", e);
			} catch (SQLException e) {
				logger.error("", e);
			}
			if(connection != null){
				StringBuilder query = new StringBuilder();
				query.append("insert into incrementer(value,currentdate,type) values(?,?,?)");
				PreparedStatement preparestat = connection.prepareStatement(query.toString());
				preparestat.setInt(1, entity.getIncrementId());
				preparestat.setDate(2, sqlDate);
				preparestat.setInt(3, entity.getFileType());
				preparestat.executeUpdate();
			}
		} catch(SQLException e){
			logger.error("", e);
		} finally{
			try {
				DataBaseConnection.getInstance().closeConnection(connection);
			} catch (SQLException e) {
				logger.error("",e);
			}
		}	
		return null;
	}
	@Override
	public int update(IncrementerEntity entity) throws ClassNotFoundException, SQLException {

		int nofRowsEffected = 0;
		Date now=new Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		logger.info("Updating the value in db");
		Connection connection = null;
		try{
			try {
				connection = DataBaseConnection.getInstance().getConnection();
			} catch (ClassNotFoundException e) {
				logger.error("", e);
			} catch (SQLException e) {
				logger.error("", e);
			}
			if(connection != null){
				PreparedStatement preparestat = connection.prepareStatement("update incrementer set value=? where currentdate=? and type=?");
				preparestat.setInt(1, entity.getIncrementId());
				preparestat.setDate(2, sqlDate);
				preparestat.setInt(3, entity.getFileType());
				nofRowsEffected = preparestat.executeUpdate();
			}
		} catch(SQLException e){
			logger.error("", e);
		} finally{
			try {
				DataBaseConnection.getInstance().closeConnection(connection);
			} catch (SQLException e) {
				logger.error("",e);
			}
		}
		return nofRowsEffected;
	}
	@Override
	public IncrementerEntity delete(IncrementerEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IncrementerEntity> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveData() {
		// TODO Auto-generated method stub

	}

}
