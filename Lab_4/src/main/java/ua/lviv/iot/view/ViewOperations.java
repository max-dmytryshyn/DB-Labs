package ua.lviv.iot.view;

import ua.lviv.iot.controller.impl.AbstractControllerImpl;
import ua.lviv.iot.model.manager.EntityManager;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class ViewOperations<E, I> {
    public static final String EXIT_KEY = "Q";
    public static final String ERROR_INVALID_KEY_INPUT = "[Error] Wrong key input. Try again";
    private static final String SQL_ERROR = "[Error] Error while executing SQL: %s";
    private static final String ERROR_MESSAGE_FORMAT = "[Error] Message: %s";

    private final AbstractControllerImpl<E, I> controller;
    private final Class<E> eClass;
    private final Scanner input = new Scanner(System.in);

    public ViewOperations(AbstractControllerImpl<E, I> controller, Class<E> eClass) {
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
        I id = ((I) input.nextLine());
        try {
            System.out.println(controller.get(id));
        } catch (SQLException | EntityNotFoundException e) {
            System.out.println(String.format(SQL_ERROR, e.getClass().getSimpleName()));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
    }

    public void update() {
        System.out.println("Input id of row to update:");
        I id = ((I) input.nextLine());
        EntityManager<E, I> entityManager = new EntityManager<E, I>(eClass);
        List<Field> fields = entityManager.getInputtableColumns();
        try {
            E entity = eClass.getConstructor().newInstance();
            for (Field field: fields){
                field.setAccessible(true);
                System.out.println("Input " + field.getName());
                inputField(entity, field);
            }
            try {
                controller.update(id, entity);
            } catch (SQLException | EntityNotFoundException e) {
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

    public void create() {
        EntityManager<E, I> entityManager = new EntityManager<E, I>(eClass);
        List<Field> fields = entityManager.getInputtableColumns();
        try {
            E entity = eClass.getConstructor().newInstance();
            for (Field field: fields){
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
        I id = ((I) input.nextLine());
        try {
            controller.delete(id);
            System.out.println("Row №" + id + " deleted");
        } catch (SQLException | EntityNotFoundException e) {
            System.out.println(String.format(SQL_ERROR, e.getClass().getSimpleName()));
            System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
        }
    }
}
