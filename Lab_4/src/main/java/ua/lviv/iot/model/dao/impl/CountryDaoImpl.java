package ua.lviv.iot.model.dao.impl;


import ua.lviv.iot.model.entity.drug.Country;

public class CountryDaoImpl extends AbstractDaoImpl<Country, Integer> {
    public CountryDaoImpl(){
        super(Country.class);
    }
}
