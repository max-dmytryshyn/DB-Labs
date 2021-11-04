package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.dao.impl.ManufacturerDaoImpl;
import ua.lviv.iot.model.entity.drug.Manufacturer;

public class ManufacturerControllerImpl extends AbstractControllerImpl<Manufacturer> {
    public ManufacturerControllerImpl(){
        super(new ManufacturerDaoImpl());
    }
}
