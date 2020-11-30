package com.harman.its.dao.idao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.harman.its.entity.Vehicle;

public interface IVehicleDao extends IDao<Vehicle>{
	public List<Vehicle> selectAllByUserID(long userId) throws SQLException, ClassNotFoundException, ParseException;
}
