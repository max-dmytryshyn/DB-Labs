package ua.lviv.iot.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<E> {

    List<E> getAll() throws SQLException;

    E get(Integer id) throws SQLException;

    void create(E entity) throws SQLException;

    void update(Integer id, E entity) throws SQLException;

    void delete(Integer id) throws SQLException;
}
