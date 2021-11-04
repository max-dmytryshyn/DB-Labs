package ua.lviv.iot.view;

import ua.lviv.iot.controller.impl.AbstractControllerImpl;

import javax.persistence.Column;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewOperations<E> {
    public static final String EXIT_KEY = "Q";
    public static final String ERROR_INVALID_KEY_INPUT = "[Error] Wrong key input. Try again";
    private static final String SQL_ERROR = "[Error] Error while executing SQL: %s";
    private static final String ERROR_MESSAGE_FORMAT = "[Error] Message: %s";

    private final AbstractControllerImpl<E> controller;
    private final Class<E> eClass;
    private final Scanner input = new Scanner(System.in);

    public ViewOperations(AbstractControllerImpl<E> controller, Class<E> eClass) {
        this.controller = controller;
        this.eClass = eClass;
    }

    private void inputField(E entity, Field field) throws IllegalAccessException {
        String inputValue = input.nextLine();
        Class fieldType = field.getType();
        if (fieldType == String.class) {
            field.set(entity, inputValue);
        } else if (fieldType == Integer.class) {
            field.set(entity, Integer.parseInt(inputValue));
        } else if (fieldType == Double.class) {
            field.set(entity, Double.parseDouble(inputValue));
        } else if (fieldType == Timestamp.class) {
            field.set(entity, Timestamp.valueOf(inputValue));
        }
    }

    public void getAll() {
        try {
            List<E> entities = controller.getAll();
            if (entities != null) {
                for (E entity : entities) {
                    System.out.println(entity.toString());
                }
            } else {
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(SQL_ERROR);
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }

    }

    public void get() {
        System.out.println("Input id of row to find:");
        Integer id = Integer.parseInt(input.nextLine());
        System.out.println(id.getClass());
        try {
            System.out.println(controller.get(id));
        } catch (SQLException | EntityNotFoundException e) {
            System.out.println(String.format(SQL_ERROR, e.getClass().getSimpleName()));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
    }

    public void update() {
        System.out.println("Input id of row to update:");
        Integer id = Integer.parseInt(input.nextLine());
        List<Field> fields = Arrays.stream(eClass.getDeclaredFields()).filter(field -> {
            return field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Id.class);
        }).collect(Collectors.toList());
        try {
            E entity = eClass.getConstructor().newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println("Input " + field.getName());
                inputField(entity, field);
            }
            Field idField = Arrays.stream(eClass.getDeclaredFields()).filter(field -> {
                return field.isAnnotationPresent(Id.class);
            }).collect(Collectors.toList()).get(0);
            idField.setAccessible(true);
            idField.set(entity, id);
            try {
                controller.update(id, entity);
            } catch (SQLException | EntityNotFoundException e) {
                System.out.println(String.format(SQL_ERROR, e.getClass().getSimpleName()));
                System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create() {
        List<Field> fields = Arrays.stream(eClass.getDeclaredFields()).filter(field -> {
            return field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Id.class);
        }).collect(Collectors.toList());
        try {
            E entity = eClass.getConstructor().newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println("Input " + field.getName());
                inputField(entity, field);
            }
            try {
                controller.create(entity);
            } catch (SQLException e) {
                System.out.println(String.format(SQL_ERROR, e.getClass().getSimpleName()));
                System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        System.out.println("Input id of row to delete:");
        Integer id = Integer.parseInt(input.nextLine());
        try {
            controller.delete(id);
            System.out.println("Row №" + id + " deleted");
        } catch (SQLException | EntityNotFoundException e) {
            System.out.println(String.format(SQL_ERROR, e.getClass().getSimpleName()));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
    }
}
