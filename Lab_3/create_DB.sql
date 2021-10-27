CREATE DATABASE IF NOT EXISTS patients_data;
USE patients_data;

DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor_appointment_has_drug;
DROP TABLE IF EXISTS drug;
DROP TABLE IF EXISTS manufacturer;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS doctor_appointment;
DROP TABLE IF EXISTS doctor_personal_file;
DROP TABLE IF EXISTS hospital;
DROP TABLE IF EXISTS tracker_data;
DROP TABLE IF EXISTS medical_card;

CREATE TABLE hospital (
	id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL, 
    address VARCHAR(45) NOT NULL,
    
    CONSTRAINT pk_hospital PRIMARY KEY (id)
);

CREATE TABLE doctor_personal_file(
	id INT AUTO_INCREMENT, 
	name VARCHAR(45) NOT NULL, 
	surname VARCHAR(45) NOT NULL,
	hospital_id INT NOT NULL,
    
    CONSTRAINT pk_doc_pnl_file PRIMARY KEY (id),
    CONSTRAINT fk_doc_pnl_file_hospital
    FOREIGN KEY (hospital_id)
	REFERENCES hospital (id),
    
    INDEX doc_pnl_file_name_surname_idx (name, surname)
);

CREATE TABLE medical_card(
	id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    birth_date DATETIME NOT NULL,
    
    CONSTRAINT pk_med_card PRIMARY KEY (id),
    
    INDEX med_card_name_surname_idx (name, surname)
);

CREATE TABLE doctor_appointment(
	id INT AUTO_INCREMENT,
    date DATETIME NOT NULL,	
    recommendation VARCHAR(45),
    doctor_personal_file_id INT NOT NULL,
    medical_card_id INT NOT NULL,
    
    CONSTRAINT pk_doc_appointment PRIMARY KEY (id),
    CONSTRAINT fk_doc_appointment_doc_pnl_file
    FOREIGN KEY (doctor_personal_file_id)
    REFERENCES doctor_personal_file (id),
    CONSTRAINT fk_doc_appointment_med_card
    FOREIGN KEY (medical_card_id)
    REFERENCES medical_card (id),
    
    INDEX doc_appointment_date_idx (date),
    INDEX fk_doc_appointment_med_card_idx (medical_card_id)
);

CREATE TABLE country(
	id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    
    CONSTRAINT pk_country PRIMARY KEY (id)
);

CREATE TABLE manufacturer(
	id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    country_id INT NOT NULL,
	
    CONSTRAINT pk_manufacturer PRIMARY KEY (id),
    CONSTRAINT fk_manufacturer_country
    FOREIGN KEY (country_id)
    REFERENCES country (id)
);

CREATE TABLE drug(
	id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(45) NOT NULL,
    price DECIMAL(10, 2),
    manufacturer_id INT NOT NULL,
    
    CONSTRAINT pk_drug PRIMARY KEY (id, manufacturer_id),
    CONSTRAINT fk_drug_manufacturer
    FOREIGN KEY (manufacturer_id)
    REFERENCES manufacturer (id)
);

CREATE TABLE doctor_appointment_has_drug(
	doctor_appointment_id INT NOT NULL,
    drug_id INT NOT NULL,
    
    CONSTRAINT pk_doc_appointment_has_drug PRIMARY KEY (doctor_appointment_id, drug_id),
    CONSTRAINT fk_doc_appointment_has_drug_doc_appointment
    FOREIGN KEY (doctor_appointment_id)
    REFERENCES doctor_appointment (id),
    CONSTRAINT fk_doc_appointment_has_drug_drug
    FOREIGN KEY (drug_id)
    REFERENCES drug (id)
);

CREATE TABLE tracker_data(
	id INT AUTO_INCREMENT,
    date DATETIME,
    systolic_blood_pressure TINYINT(250) UNSIGNED,
    diastolic_blood_pressure TINYINT(160) UNSIGNED,
    heart_rate TINYINT(250) UNSIGNED,
    temperature DECIMAL(3,1) UNSIGNED,
    medical_card_id INT NOT NULL,
    
    CONSTRAINT pk_tracker_data PRIMARY KEY (id),
    CONSTRAINT fk_tracker_data_med_card 
    FOREIGN KEY (medical_card_id)
    REFERENCES medical_card (id),
    
    INDEX fk_tracker_data_med_card_idx (medical_card_id)
);

CREATE TABLE patient(
	id INT AUTO_INCREMENT,
    medical_card_id INT NOT NULL,
    hospital_id INT NOT NULL,
    doctor_personal_file_id INT NOT NULL,
    
    CONSTRAINT pk_patient PRIMARY KEY (id),
    CONSTRAINT fk_patient_med_card 
    FOREIGN KEY (medical_card_id)
    REFERENCES medical_card (id),
    CONSTRAINT fk_patient_hospital
    FOREIGN KEY (hospital_id)
    REFERENCES hospital (id),
    CONSTRAINT fk_patient_doc_pnl_file
    FOREIGN KEY (doctor_personal_file_id)
    REFERENCES doctor_personal_file (id)
);
