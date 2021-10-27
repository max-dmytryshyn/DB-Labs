package ua.lviv.iot.view;


import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.entity.drug.Country;
import ua.lviv.iot.model.entity.drug.Drug;
import ua.lviv.iot.model.entity.drug.Manufacturer;
import ua.lviv.iot.model.entity.patient.*;

import java.util.Scanner;

public class View {
    private static final String ERROR_INVALID_KEY_INPUT = ViewOperations.ERROR_INVALID_KEY_INPUT;
    private static final String EXIT_KEY = ViewOperations.EXIT_KEY;
    private static final String COUNTRY_KEY = "0";
    private static final String DRUG_KEY = "1";
    private static final String MANUFACTURER_KEY = "2";
    private static final String DOCTOR_APPOINTMENT_KEY = "3";
    private static final String DOCTOR_PERSONAL_FILE_KET = "4";
    private static final String HOSPITAL_KEY = "5";
    private static final String MEDICAL_CARD_KEY = "6";
    private static final String PATIENT_KEY = "7";
    private static final String TRACKER_DATA_KEY = "8";
    private static final String GET_ALL_KEY = "0";
    private static final String GET_BY_ID_KEY = "1";
    private static final String UPDATE_KEY = "2";
    private static final String CREATE_KEY = "3";
    private static final String DELETE_KEY = "4";
    static Scanner input = new Scanner(System.in);

    private static void printSeparator() {
        System.out.println("--------------------------------------");
    }

    private static String printMainMenu() {
        System.out.println("Choose table to work with:");
        System.out.println(COUNTRY_KEY + "-" + "Country");
        System.out.println(DRUG_KEY + "-" + "Drug");
        System.out.println(MANUFACTURER_KEY + "-" + "Manufacturer");
        System.out.println(DOCTOR_APPOINTMENT_KEY + "-" + "DoctorAppointment");
        System.out.println(DOCTOR_PERSONAL_FILE_KET + "-" + "DoctorPersonalFile");
        System.out.println(HOSPITAL_KEY + "-" + "Hospital");
        System.out.println(MEDICAL_CARD_KEY + "-" + "MedicalCard");
        System.out.println(PATIENT_KEY + "-" + "Patient");
        System.out.println(TRACKER_DATA_KEY + "-" + "TrackerData");
        System.out.println(EXIT_KEY + "-" + "Exit");
        return input.nextLine().toUpperCase();
    }

    private static String printTableMenu() {
        System.out.println("Choose what to do");
        System.out.println(GET_ALL_KEY + "-" + "Get all rows");
        System.out.println(GET_BY_ID_KEY + "-" + "Get row by id");
        System.out.println(UPDATE_KEY + "-" + "Update row");
        System.out.println(CREATE_KEY + "-" + "Create row");
        System.out.println(DELETE_KEY + "-" + "Delete row");
        System.out.println(EXIT_KEY + "-" + "Return to main menu");
        return input.nextLine().toUpperCase();
    }

    public static void execute() {

        main_label:
        while (true) {
            Class currentClass;
            AbstractControllerImpl controller;
            ViewOperations viewOperations;

            String mainMenuInput = printMainMenu();
            switch (mainMenuInput) {
                case COUNTRY_KEY:
                    currentClass = Country.class;
                    controller = new CountryControllerImpl();
                    break;
                case DRUG_KEY:
                    currentClass = Drug.class;
                    controller = new DrugControllerImpl();
                    break;
                case MANUFACTURER_KEY:
                    currentClass = Manufacturer.class;
                    controller = new ManufacturerControllerImpl();
                    break;
                case DOCTOR_APPOINTMENT_KEY:
                    currentClass = DoctorAppointment.class;
                    controller = new DoctorAppointmentControllerImpl();
                    break;
                case DOCTOR_PERSONAL_FILE_KET:
                    currentClass = DoctorPersonalFile.class;
                    controller = new DoctorPersonalFileControllerImpl();
                    break;
                case HOSPITAL_KEY:
                    currentClass = Hospital.class;
                    controller = new HospitalControllerImpl();
                    break;
                case MEDICAL_CARD_KEY:
                    currentClass = MedicalCard.class;
                    controller = new MedicalCardControllerImpl();
                    break;
                case PATIENT_KEY:
                    currentClass = Patient.class;
                    controller = new PatientControllerImpl();
                    break;
                case TRACKER_DATA_KEY:
                    currentClass = TrackerData.class;
                    controller = new TrackerDataControllerImpl();
                    break;
                case EXIT_KEY:
                    break main_label;
                default:
                    System.out.println(ERROR_INVALID_KEY_INPUT);
                    continue;
            }
            printSeparator();
            viewOperations = new ViewOperations(controller, currentClass);
            table_label:
            while (true) {
                System.out.println("You are working with " + currentClass.getSimpleName() + " table");
                String tableMenuInput = printTableMenu();
                printSeparator();
                switch (tableMenuInput) {
                    case GET_ALL_KEY:
                        viewOperations.getAll();
                        break;
                    case GET_BY_ID_KEY:
                        viewOperations.get();
                        break;
                    case UPDATE_KEY:
                        viewOperations.update();
                        break;
                    case CREATE_KEY:
                        viewOperations.create();
                        break;
                    case DELETE_KEY:
                        viewOperations.delete();
                        break;
                    case EXIT_KEY:
                        break table_label;
                    default:
                        System.out.println(ERROR_INVALID_KEY_INPUT);
                }
                printSeparator();
            }
        }
    }
}
