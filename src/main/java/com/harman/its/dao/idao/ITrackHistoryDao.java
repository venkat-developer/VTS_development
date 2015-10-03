package com.harman.its.dao.idao;

import java.sql.SQLException;
import java.util.List;

import com.harman.its.entity.TrackHistoryEntity;

public interface ITrackHistoryDao extends IDao<TrackHistoryEntity>{
	public List<TrackHistoryEntity> selectByTripId(long tripId) throws ClassNotFoundException, SQLException ;
}
