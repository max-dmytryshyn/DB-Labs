package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.dao.AbstractDao;

import java.sql.SQLException;
import java.util.List;

public class AbstractControllerImpl<E> implements AbstractController<E> {
    private AbstractDao<E> dao;

    public AbstractControllerImpl(AbstractDao<E> dao){
        this.dao = dao;
    }

    @Override
    public List<E> getAll() throws SQLException {
        return dao.getAll();
    }

    @Override
    public E get(Integer id) throws SQLException {
        return dao.get(id);
    }

    @Override
    public void create(E entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, E entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
