package com.harman.its.dao.idao;

import java.sql.SQLException;

import com.harman.its.entity.UserEntity;

public interface ILiveVehicleStatusDAO extends IDao<UserEntity>{
	public UserEntity authenticateUser(String userName,String password) throws ClassNotFoundException, SQLException ;
}
