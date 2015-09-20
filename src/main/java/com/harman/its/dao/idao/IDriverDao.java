package com.harman.its.dao.idao;

import java.sql.SQLException;

import com.harman.its.entity.Driver;

public interface IDriverDao extends IDao<Driver>{
	public Driver selectByDriverId(long driverId) throws ClassNotFoundException, SQLException ;
}
