package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.patient.MedicalCard;

public class MedicalCardDaoImpl extends AbstractDaoImpl<MedicalCard, Integer> {
    public MedicalCardDaoImpl(){
        super(MedicalCard.class);
    }
}
