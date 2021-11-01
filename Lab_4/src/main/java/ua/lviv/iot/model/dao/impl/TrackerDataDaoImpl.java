package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.patient.TrackerData;

public class TrackerDataDaoImpl extends AbstractDaoImpl<TrackerData, Integer> {
    public TrackerDataDaoImpl(){
        super(TrackerData.class);
    }
}
