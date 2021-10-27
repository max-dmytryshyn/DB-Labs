package ua.lviv.iot.model.manager;

import lombok.AllArgsConstructor;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class EntityManager<E, I> {
    private final Class<E> eClass;
    private final Field[] fields;

    public EntityManager(Class<E> eClass) {
        this.eClass = eClass;
        this.fields = eClass.getDeclaredFields();
    }

    public Class<E> getEntityClass() {
        return this.eClass;
    }

    public Field[] getEntityFields() {
        return this.fields.clone();
    }

    public String getTableName() {
        return this.eClass.getAnnotation(Table.class).name();
    }

    public String getPrimaryKeyName() {
        for (Field field : this.fields) {
            if (field.isAnnotationPresent(Id.class)) {
                return field.getAnnotation(Column.class).name();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public I getPrimaryKeyValue(E entity) throws IllegalArgumentException, IllegalAccessException {
        for (Field field : this.fields) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                return (I) field.get(entity);
            }
        }
        return null;
    }

    public List<Field> getColumns() {
        List<Field> columns = new LinkedList<Field>();
        for (Field field : this.fields) {
            if (field.isAnnotationPresent(Column.class)) {
                columns.add(field);
            }
        }
        return columns;
    }

    public List<String> getColumnsName() {
        List<String> columnsNames = new LinkedList<String>();
        List<Field> columns = this.getColumns();
        for (Field column : columns) {
            columnsNames.add(column.getAnnotation(Column.class).name());
        }
        return columnsNames;
    }

    public List<Field> getInputtableColumns() {
        List<Field> inputtableColumns = new LinkedList<Field>();
        List<Field> columns = this.getColumns();
        for (Field column : columns) {
            if (!column.isAnnotationPresent(NotInputtable.class)) {
                inputtableColumns.add(column);
            }
        }
        return inputtableColumns;
    }

    public List<String> getInputtableColumnsNames() {
        List<String> inputtableColumnsNames = new LinkedList<String>();
        List<Field> inputtableColumns = this.getInputtableColumns();
        for (Field column : inputtableColumns) {
            inputtableColumnsNames.add(column.getAnnotation(Column.class).name());
        }
        return inputtableColumnsNames;
    }

    public Field setColumnValueByName(E entity, String fieldName, Object fieldValue)
            throws IllegalArgumentException, IllegalAccessException {
        List<Field> columns = this.getInputtableColumns();
        for (Field column : columns) {
            if (column.getName().equals(fieldName)) {
                column.setAccessible(true);
                column.set(entity, fieldValue);
                return column;
            }
        }
        return null;
    }

    public String getInputtableColumnsNamesSeparatedByCommas() {
        return String.join(", ", this.getInputtableColumnsNames());
    }

    public String getCreateColumnsString(E entity) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder createColumnsString = new StringBuilder();
        List<Field> columns = this.getInputtableColumns();
        for (Field column : columns) {
            column.setAccessible(true);
            if (column.getType() == Timestamp.class || column.getType() == String.class) {
                createColumnsString.append("'");
                createColumnsString.append(column.get(entity).toString());
                createColumnsString.append("'");
            } else {
                createColumnsString.append(column.get(entity).toString());
            }
            createColumnsString.append(", ");
        }
        createColumnsString.delete(createColumnsString.length() - 2, createColumnsString.length() - 1);
        return createColumnsString.toString();
    }

    public String getUpdateColumnsString(E entity) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder updateColumnsString = new StringBuilder();
        List<Field> columns = this.getInputtableColumns();
        List<String> columnsNames = this.getInputtableColumnsNames();
        for (int i = 0; i < columns.size(); i++) {
            Field column = columns.get(i);
            String columnName = columnsNames.get(i);
            column.setAccessible(true);
            updateColumnsString.append(columnName);
            updateColumnsString.append("=");
            if (column.getType() == Timestamp.class || column.getType() == String.class) {
                updateColumnsString.append("'");
                updateColumnsString.append(column.get(entity).toString());
                updateColumnsString.append("'");
            } else {
                updateColumnsString.append(column.get(entity).toString());
            }
            updateColumnsString.append(", ");
        }
        updateColumnsString.delete(updateColumnsString.length() - 2, updateColumnsString.length() - 1);
        return updateColumnsString.toString();
    }
}
