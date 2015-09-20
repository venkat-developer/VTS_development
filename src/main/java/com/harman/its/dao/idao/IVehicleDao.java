package com.harman.its.dao.idao;

import java.sql.SQLException;

import com.harman.its.entity.Vehicle;

public interface IVehicleDao extends IDao<Vehicle>{
	public Vehicle selectByVehicleId(long vehicleId) throws ClassNotFoundException, SQLException ;
}
