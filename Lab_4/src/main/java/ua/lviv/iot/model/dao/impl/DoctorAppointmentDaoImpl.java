package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.patient.DoctorAppointment;

public class DoctorAppointmentDaoImpl extends AbstractDaoImpl<DoctorAppointment, Integer> {
    public DoctorAppointmentDaoImpl(){
        super(DoctorAppointment.class);
    }
}
