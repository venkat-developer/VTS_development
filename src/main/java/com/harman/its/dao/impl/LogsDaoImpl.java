package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.its.dao.idao.ILogsDao;
import com.harman.its.entity.LogsEntity;
import com.harman.its.utils.DataBaseConnection;
import com.harman.its.utils.DateUtils;


/**
 * 
 * @author VAmukapati
 *
 */
/**
 *CREATE TABLE logs(
  id bigint NOT NULL DEFAULT nextval('log_id_sequence'::regclass),
  deviceid character varying(20), -- Device Id of request.
  devicetype integer, -- device type of the Request
  ipaddress character varying(20), -- Ip address of the requested device.
  log text, -- Cause of the request failure.
  userid bigint,
  requestedat timestamp with time zone
)WITH (
  OIDS=FALSE
);
	ALTER TABLE logs
  		OWNER TO postgres;
	COMMENT ON TABLE logs
  	IS 'logs of all the requests.';
	COMMENT ON COLUMN logs.deviceid IS 'Device Id of request.';
	COMMENT ON COLUMN logs.devicetype IS 'device type of the Request';
	COMMENT ON COLUMN logs.ipaddress IS 'Ip address of the requested device.';
	COMMENT ON COLUMN logs.log IS 'Cause of the request failure.';
 */
public class LogsDaoImpl implements ILogsDao{
	Logger logger = Logger.getLogger(getClass());

	@Override
	public LogsEntity insert(LogsEntity entity)throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement statement = null;
		try {

			try {
				connection = DataBaseConnection.getInstance().getConnection();
			} catch (ClassNotFoundException e) {
				logger.error("",e);
			}
			if(connection != null){
				statement = connection.createStatement();
				StringBuilder sideASQl = new StringBuilder();
				sideASQl.append("insert into logs(");
				sideASQl.append("userid,date,ipaddress,olddata,newdata)");
				sideASQl.append(" values(");
				sideASQl.append(entity.getUserId());
				sideASQl.append(",'");
				sideASQl.append(DateUtils.convertJavaDateToSQLDate(entity.getRequestedAt()));
				sideASQl.append("','");
				sideASQl.append(entity.getIpAddress());
				sideASQl.append("','");
				sideASQl.append(entity.getLog());
				sideASQl.append("','");
				sideASQl.append(entity.getLog());
				sideASQl.append("')");
				statement.executeUpdate(sideASQl.toString());
			}
			return entity;
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
	}

	@Override
	public int update(LogsEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LogsEntity delete(LogsEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogsEntity> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveData() {
		// TODO Auto-generated method stub
	}
	public List<LogsEntity> selectLastLogin(long userId){
		List<LogsEntity> logsList = new ArrayList<LogsEntity>();
		Connection connection = null;
		Statement statement = null;
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
			StringBuilder sql= new StringBuilder();
			sql.append("select * from logs where ");
			sql.append("userid = ");
			sql.append(userId);
			sql.append(" and newdata like('%LOGGED IN') order by date desc limit 2");
			statement = connection.createStatement();
			ResultSet logsResultSet = statement.executeQuery(sql.toString());
			while(logsResultSet.next()){
				logsList.add(new LogsEntity(logsResultSet.getLong("userid"), 
						new Date(logsResultSet.getTimestamp("date").getTime()), 
						logsResultSet.getString("ipaddress"),
						logsResultSet.getString("newdata")));
			}
		} catch (SQLException e) {
			logger.error("" + e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					DataBaseConnection.getInstance().closeConnection(connection);
				} catch (SQLException e) {
					logger.error("",e);
				}
			}

		}

		return logsList;
	}
}