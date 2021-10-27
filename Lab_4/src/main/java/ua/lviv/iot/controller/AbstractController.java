package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController <E, I> {

    List<E> getAll() throws SQLException;

    E get(I id) throws SQLException;

    void create(E entity) throws SQLException;

    void update(I id, E entity) throws SQLException;

    void delete(I id) throws SQLException;
}
