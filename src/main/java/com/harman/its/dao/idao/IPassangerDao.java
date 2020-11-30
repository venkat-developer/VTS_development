package com.harman.its.dao.idao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.harman.its.entity.Passenger;

public interface IPassangerDao extends IDao<Passenger>{
	public List<Passenger> selectAllByUserID(long userId) throws SQLException, ClassNotFoundException, ParseException;	
	
}
