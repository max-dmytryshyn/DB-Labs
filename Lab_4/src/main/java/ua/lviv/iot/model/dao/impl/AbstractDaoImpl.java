package ua.lviv.iot.model.dao.impl;

import lombok.AllArgsConstructor;
import ua.lviv.iot.model.dao.AbstractDao;
import ua.lviv.iot.model.manager.EntityManager;
import ua.lviv.iot.model.persistant.ConnectionManager;
import ua.lviv.iot.model.transformer.EntityTransformer;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Table;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public abstract class AbstractDaoImpl<E, I> implements AbstractDao<E, I> {
    private static final String GET_ALL_TEMPLATE = "SELECT * FROM %s;";
    private static final String GET_BY_ID_TEMPLATE = "SELECT * FROM %s WHERE %s=%s;";
    private static final String CREATE_TEMPLATE = "INSERT INTO %s(%s) VALUES(%s);";
    private static final String UPDATE_TEMPLATE = "UPDATE %s SET %s WHERE %s=%s;";
    private static final String DELETE_TEMPLATE = "DELETE FROM %s WHERE %s=%s;";

    private static final String ERROR_EXCEPTION_TEMPLATE = "[Error] Exception while %s";
    private static final String ERROR_MESSAGE_TEMPLATE = "[Error] Message: %s";

    private final Class<E> eClass;
    private final EntityTransformer<E, I> entityTransformer;
    private final EntityManager<E, I> entityManager;

    public AbstractDaoImpl(Class<E> eClass) {
        this.eClass = eClass;
        this.entityManager = new EntityManager<E, I>(eClass);
        this.entityTransformer = new EntityTransformer<E, I>(eClass);
    }

    @Override
    public List<E> getAll() throws SQLException {
        List<E> entityList = new LinkedList<E>();
        if (this.eClass.isAnnotationPresent(Table.class)) {
            Connection connection = ConnectionManager.getConnection();
            String tableName = this.entityManager.getTableName();
            String sqlStatement = String.format(GET_ALL_TEMPLATE, tableName);

            try (PreparedStatement ps = connection.prepareStatement(sqlStatement)) {
                try (ResultSet resultSet = ps.executeQuery()) {
                    while (resultSet.next()) {
                        entityList.add(entityTransformer.fromResultSetToEntity(resultSet));
                    }
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "transforming data into objects"));
                    System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
                }
            }
        }
        return entityList;
    }

    private List<E> getByFieldValue(String fieldName, Object fieldValue) throws SQLException {
        List<E> entityList = new LinkedList<E>();
        Connection connection = ConnectionManager.getConnection();
        String tableName = this.entityManager.getTableName();
        String sqlStatement = String.format(GET_BY_ID_TEMPLATE, tableName, fieldName, fieldValue);
        try (PreparedStatement ps = connection.prepareStatement(sqlStatement)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entityList.add(entityTransformer.fromResultSetToEntity(resultSet));
                }
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "transforming data into objects"));
                System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
            }
        }
        return entityList;
    }

    @Override
    public E get(I id) throws SQLException {
        List<E> entityList = this.getByFieldValue(this.entityManager.getPrimaryKeyName(), id);
        if (entityList.size() > 0) {
            return entityList.get(0);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void create(E entity) throws SQLException {
        try {
            Connection connection = ConnectionManager.getConnection();
            String tableName = this.entityManager.getTableName();
            String columnsNames = this.entityManager.getInputtableColumnsNamesSeparatedByCommas();
            String values = this.entityManager.getCreateColumnsString(entity);
            String sqlStatement = String.format(CREATE_TEMPLATE, tableName, columnsNames, values);
            PreparedStatement ps = connection.prepareStatement(sqlStatement);
            ps.executeUpdate();


        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
            System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "transforming data into objects"));
            System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
        }
    }

    @Override
    public void update(I id, E entity) throws SQLException {
        try {
            Connection connection = ConnectionManager.getConnection();
            String tableName = this.entityManager.getTableName();
            String primaryKeyName = this.entityManager.getPrimaryKeyName();
            String parametersSetting = this.entityManager.getUpdateColumnsString(entity);
            String sqlStatement = String.format(UPDATE_TEMPLATE, tableName, parametersSetting, primaryKeyName, id);
            PreparedStatement ps = connection.prepareStatement(sqlStatement);
            if (ps.executeUpdate() == 0) {
                throw new EntityNotFoundException();
            }

        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
            System.out.println(String.format(ERROR_EXCEPTION_TEMPLATE, "transforming data into objects"));
            System.out.println(String.format(ERROR_MESSAGE_TEMPLATE, e.getMessage()));
        }
    }

    @Override
    public void delete(I id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        String tableName = this.entityManager.getTableName();
        String primaryKeyName = this.entityManager.getPrimaryKeyName();
        String sqlStatement = String.format(DELETE_TEMPLATE, tableName, primaryKeyName, id);

        PreparedStatement ps = connection.prepareStatement(sqlStatement);
        if (ps.executeUpdate() == 0) {
            throw new EntityNotFoundException();
        }
    }
}
