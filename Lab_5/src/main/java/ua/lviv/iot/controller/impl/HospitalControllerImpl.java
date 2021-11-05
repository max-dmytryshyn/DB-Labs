package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.HospitalDaoImpl;
import ua.lviv.iot.model.entity.patient.Hospital;

public class HospitalControllerImpl extends AbstractControllerImpl<Hospital> {
    public HospitalControllerImpl() {
        super(new HospitalDaoImpl());
    }
}
