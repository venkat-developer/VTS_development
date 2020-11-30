package com.harman.its.dao.idao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.harman.its.entity.Driver;

public interface IDriverDao extends IDao<Driver>{
	public List<Driver> selectAllByUserID(long userId) throws SQLException, ClassNotFoundException, ParseException;	
}
