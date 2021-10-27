package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.dao.AbstractDao;

import java.sql.SQLException;
import java.util.List;

public class AbstractControllerImpl<E, I> implements AbstractController<E, I> {
    private AbstractDao<E, I> dao;

    public AbstractControllerImpl(AbstractDao<E, I> dao){
        this.dao = dao;
    }

    @Override
    public List<E> getAll() throws SQLException {
        return dao.getAll();
    }

    @Override
    public E get(I id) throws SQLException {
        return dao.get(id);
    }

    @Override
    public void create(E entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(I id, E entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(I id) throws SQLException {
        dao.delete(id);
    }
}
