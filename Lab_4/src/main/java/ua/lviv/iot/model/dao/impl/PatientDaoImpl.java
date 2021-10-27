package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.patient.Patient;

public class PatientDaoImpl extends AbstractDaoImpl<Patient, Integer> {
    public PatientDaoImpl(){
        super(Patient.class);
    }
}
