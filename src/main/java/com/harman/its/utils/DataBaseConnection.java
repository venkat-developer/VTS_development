package com.harman.its.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DataBaseConnection {
	Logger logger = Logger.getLogger(DataBaseConnection.class);
	private static String DRIVER_NAME = "org.postgresql.Driver";
	private static String Connection_URL = "jdbc:postgresql://localhost/demodb";
	private static String DB_User_Name = "postgres";
	private static String DB_Password = "demo@123";
	public static DataBaseConnection _instance = null;
	/**
	 * Creating singleton object.
	 * @return
	 */
	public static DataBaseConnection getInstance(){
		if(_instance ==null){
			_instance = new DataBaseConnection();
		}
		return _instance;
	}
	/**
	 * Get the connection from DB 
	 * @return Connection
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection connection=null;
		Class.forName(DRIVER_NAME);
		connection=DriverManager.getConnection(Connection_URL,DB_User_Name,DB_Password);
		return connection;
	}
	public void closeConnection(Connection connection) throws SQLException{
		if(connection != null){
			connection.close();
		}
	}	
	public void closeStatement(Statement statement) throws SQLException{
		if(statement != null){
			statement.close();
		}
	}
}
