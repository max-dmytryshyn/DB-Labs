package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.DrugDaoImpl;
import ua.lviv.iot.model.entity.drug.Drug;

public class DrugControllerImpl extends AbstractControllerImpl<Drug, Integer> {
    public DrugControllerImpl(){
        super(new DrugDaoImpl());
    }
}
