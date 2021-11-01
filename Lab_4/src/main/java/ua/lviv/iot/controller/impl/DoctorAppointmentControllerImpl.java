package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.DoctorAppointmentDaoImpl;
import ua.lviv.iot.model.entity.patient.DoctorAppointment;

public class DoctorAppointmentControllerImpl extends AbstractControllerImpl<DoctorAppointment, Integer> {
    public DoctorAppointmentControllerImpl(){
        super(new DoctorAppointmentDaoImpl());
    }
}
