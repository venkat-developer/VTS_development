package com.harman.its.dao.idao;

import java.sql.SQLException;

import com.harman.its.entity.LogsEntity;

public interface ILogsDao extends IDao<LogsEntity>{

	LogsEntity insert(LogsEntity entity) throws ClassNotFoundException, SQLException;

}
