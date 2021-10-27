package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.patient.Hospital;

public class HospitalDaoImpl extends AbstractDaoImpl<Hospital, Integer> {
    public HospitalDaoImpl(){
        super(Hospital.class);
    }
}
