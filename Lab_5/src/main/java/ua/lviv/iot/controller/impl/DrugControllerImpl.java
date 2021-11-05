package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.DrugDaoImpl;
import ua.lviv.iot.model.entity.drug.Drug;

public class DrugControllerImpl extends AbstractControllerImpl<Drug> {
    public DrugControllerImpl() {
        super(new DrugDaoImpl());
    }
}
