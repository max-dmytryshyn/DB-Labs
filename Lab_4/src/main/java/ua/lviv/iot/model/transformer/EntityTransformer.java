package ua.lviv.iot.model.transformer;

import ua.lviv.iot.model.manager.EntityManager;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EntityTransformer<E, I> {
    private final EntityManager<E, I> entityManager;

    public EntityTransformer(Class<E> eClass) {
        this.entityManager = new EntityManager<E, I>(eClass);
    }

    public E fromResultSetToEntity(ResultSet resultSet) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, SQLException {
        E entity = entityManager.getEntityClass().getConstructor().newInstance();
        for (Field field : entityManager.getColumns()) {
            Column column = field.getAnnotation(Column.class);
            String name = column.name();
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (fieldType == String.class) {
                field.set(entity, resultSet.getString(name));
            } else if (fieldType == Integer.class) {
                field.set(entity, resultSet.getInt(name));
            } else if (fieldType == Double.class) {
                field.set(entity, resultSet.getDouble(name));
            } else if (fieldType == Timestamp.class) {
                field.set(entity, resultSet.getTimestamp(name));
            } else if (fieldType == BigDecimal.class) {
                field.set(entity, resultSet.getBigDecimal(name));
            }
        }
        return entity;
    }

}
