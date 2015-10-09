package com.harman.its.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.postgis.PGgeometry;

import com.harman.its.dao.idao.IIdleDao;
import com.harman.its.entity.IdlePoints;
import com.harman.its.entity.LongPrimaryKey;
import com.harman.its.utils.DataBaseConnection;
import com.harman.its.utils.DateUtils;



public class IdleDaoImpl implements IIdleDao{
	Logger logger = Logger.getLogger(getClass());

	@Override
	public IdlePoints insert(IdlePoints entity) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(IdlePoints entity) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IdlePoints delete(IdlePoints entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdlePoints> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	public List<IdlePoints> selectAllIdlePointsBetweenDatesWithLimit(long tripId, Date startDate, Date endDate) throws ClassNotFoundException, SQLException {
		List<IdlePoints> idlePointList = new ArrayList<IdlePoints>();
		List<IdlePoints> idlePointReturnList = new ArrayList<IdlePoints>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DataBaseConnection.getInstance().getConnection();
			statement = connection.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from idlepoints where tripid = ");
			sql.append(tripId);
			sql.append(" and endtime > '");
			sql.append(DateUtils.convertJavaDateToSQLDate(startDate));
			sql.append("' and starttime < '");
			sql.append(DateUtils.convertJavaDateToSQLDate(endDate));
			sql.append("' order by starttime ");  //limit 15

			logger.debug("Query is "+sql.toString());
			ResultSet rs = statement.executeQuery(sql.toString());
			while(rs.next()){
				PGgeometry geom = (PGgeometry)rs.getObject("idlelocation");
				IdlePoints idlePoints = new IdlePoints(new LongPrimaryKey(rs.getLong("id")),
						rs.getLong("tripid"),
						geom.getGeometry(),
						new Date(rs.getTimestamp("starttime").getTime()),
						new Date(rs.getTimestamp("endtime").getTime()),
						rs.getString("locationname"));
				idlePointList.add(idlePoints);
			}
			if(idlePointList.size() != 0){
				for(IdlePoints idlePoint : idlePointList){
					Date endTime = idlePoint.getEndtime(); //EndTime of the trip
					long endDateMilliSeconds =endTime.getTime(); //MilliSeconds Of EndTime
					Date selectedEndTime = new Timestamp(endDate.getTime()); //Selected EndTime from TimeFrame
					long selectedEndDateMilliSeconds=selectedEndTime.getTime();//MilliSeconds Of selectedEndTime

					Date startTime = idlePoint.getStarttime();//StartTime of the trip
					long startTimeMilliSeconds =startTime.getTime();//MilliSeconds Of StartTime
					Date selectedStartTime = new Timestamp(startDate.getTime());//Selected StartTime from TimeFrame
					long selectedStartTimeMilliSeconds=selectedStartTime.getTime();//MilliSeconds Of SelectedTimeFrame

					//gives the output in IdlePointReport according to selected TimeFrame(Time Duration)
					if(startTimeMilliSeconds<selectedStartTimeMilliSeconds && endDateMilliSeconds>selectedEndDateMilliSeconds){
						logger.debug("You are in 1111 ");
						idlePoint.setStarttime(new Timestamp(startDate.getTime()));
						idlePoint.setEndtime(new Timestamp(endDate.getTime()));
						idlePointReturnList.add(idlePoint);
					}else if(endDateMilliSeconds>selectedEndDateMilliSeconds){
						logger.debug("You are in 2222 ");
						idlePoint.setEndtime(new Timestamp(endDate.getTime()));
						idlePointReturnList.add(idlePoint);
					}else if(startTimeMilliSeconds<selectedStartTimeMilliSeconds){
						logger.debug("You are in 3333 ");
						idlePoint.setStarttime(new Timestamp(startDate.getTime()));
						idlePointReturnList.add(idlePoint);
					}else{
						logger.debug("You are in 4444 ");
						idlePointReturnList.add(idlePoint);
					}
				}
			}else{
				logger.debug("Idle reports size is  "+idlePointReturnList.size());
			}
			return idlePointReturnList;
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
	}

}