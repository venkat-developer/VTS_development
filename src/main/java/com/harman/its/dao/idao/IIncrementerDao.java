package com.harman.its.dao.idao;

import java.sql.SQLException;

import com.harman.its.entity.IncrementerEntity;

public interface IIncrementerDao extends IDao<IncrementerEntity>{
	public int getLatestIdByType(int type) throws ClassNotFoundException, SQLException;
}
