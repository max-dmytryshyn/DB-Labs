package ua.lviv.iot.model.dao.impl;

import ua.lviv.iot.model.entity.drug.Manufacturer;

public class ManufacturerDaoImpl extends AbstractDaoImpl<Manufacturer, Integer> {
    public ManufacturerDaoImpl(){
        super(Manufacturer.class);
    }
}
