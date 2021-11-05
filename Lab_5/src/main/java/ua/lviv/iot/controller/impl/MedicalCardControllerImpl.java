package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.MedicalCardDaoImpl;
import ua.lviv.iot.model.entity.patient.MedicalCard;

public class MedicalCardControllerImpl extends AbstractControllerImpl<MedicalCard> {
    public MedicalCardControllerImpl() {
        super(new MedicalCardDaoImpl());
    }
}
