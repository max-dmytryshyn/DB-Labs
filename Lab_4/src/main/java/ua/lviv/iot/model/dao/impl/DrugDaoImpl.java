package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.drug.Drug;

public class DrugDaoImpl extends AbstractDaoImpl<Drug, Integer> {
    public DrugDaoImpl(){
        super(Drug.class);
    }
}
