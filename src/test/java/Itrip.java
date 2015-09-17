package com.i10n.db.idao;

import java.util.List;

import com.harman.its.entity.LongPrimaryKey;

public interface ITripDetailsDAO extends IDAO<TripDetails, LongPrimaryKey>  {
    public List<TripDetails> getActiveTripDetailsWithLiveStatusForTheUser(LongPrimaryKey userId);
}
