package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.PatientDaoImpl;
import ua.lviv.iot.model.entity.patient.Patient;

public class PatientControllerImpl extends AbstractControllerImpl<Patient> {
    public PatientControllerImpl() {
        super(new PatientDaoImpl());
    }
}
