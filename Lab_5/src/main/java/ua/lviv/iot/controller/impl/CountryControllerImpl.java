package ua.lviv.iot.controller.impl;


import ua.lviv.iot.model.dao.impl.CountryDaoImpl;
import ua.lviv.iot.model.entity.drug.Country;

public class CountryControllerImpl extends AbstractControllerImpl<Country> {
    public CountryControllerImpl(){
        super(new CountryDaoImpl());
    }
}
