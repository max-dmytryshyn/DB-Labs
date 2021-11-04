package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.TrackerDataDaoImpl;
import ua.lviv.iot.model.entity.patient.TrackerData;

public class TrackerDataControllerImpl extends AbstractControllerImpl<TrackerData> {
    public TrackerDataControllerImpl(){
        super(new TrackerDataDaoImpl());
    }
}
