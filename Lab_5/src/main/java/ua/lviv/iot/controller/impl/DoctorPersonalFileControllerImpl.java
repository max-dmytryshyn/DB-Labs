package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.DoctorPersonalFileDaoImpl;
import ua.lviv.iot.model.entity.patient.DoctorPersonalFile;

public class DoctorPersonalFileControllerImpl extends AbstractControllerImpl<DoctorPersonalFile> {
    public DoctorPersonalFileControllerImpl() {
        super(new DoctorPersonalFileDaoImpl());
    }
}
