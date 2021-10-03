DELETE FROM patient;

DELETE FROM patientsData.country;
DELETE FROM doctor_appointment;
DELETE FROM doctor_appointment_has_drug;
DELETE FROM doctor_personal_file;
DELETE FROM drug;
DELETE FROM hospital;
DELETE FROM manufacturer;
DELETE FROM medical_card;

DELETE FROM tracker_data;

INSERT INTO hospital(name, adress) 
VALUES
('Durka1', 'adress1'),
('Durka2', 'adress2'),
('Durka3', 'adress3'),
('Durka4', 'adress4'),
('Durka5', 'adress5');

INSERT INTO doctor_personal_file(name, surname, hospital_id)
VALUES
('What a Name1', 'What a Surname1', 1),
('What a Name2', 'What a Surname2', 2),
('What a Name3', 'What a Surname3', 3),
('What a Name4', 'What a Surname4', 4),
('What a Name5', 'What a Surname5', 5);

INSERT INTO medical_card(name, surname, birth_date)
VALUES
('Max', 'Dmytryshyn', '2003-04-04'),
('Andriy', 'Tyslyak', '2002-11-22'),
('Kostya', 'Mininkov', '2003-05-15'),
('Nastya', 'Chumak', '2003-09-15'),
('Danylo', 'Myroshnychenko', '2003-04-20');

INSERT INTO doctor_appointment(date, recomendation, doctor_personal_file_id, medical_card_id)
VALUES
(CURDATE(), 'None', 1, 1),
(CURDATE(), 'None', 2, 2),
(CURDATE(), 'None', 3, 3),
(CURDATE(), 'None', 4, 4),
(CURDATE(), 'None', 5, 5);

INSERT INTO country(name)
VALUES
('Ukraine'),
('USA'),
('Germany'),
('UK');

INSERT INTO manufacturer(name,country_id)
VALUES
('UkrLiky', 1),
('USADrugs', 2),
('UKDrugs', 4),
('DeutscheMedizin', 3);

INSERT INTO drug(name, price, manufacturer_id)
VALUES
("Aspiryn", 20, 1),
("Aspiryn", 100, 2),
("Aspiryn", 200, 3),
("Aspiryn", 150, 4);

INSERT INTO doctor_appointment_has_drug(doctor_appointment_id, drug_id)
VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO tracker_data(date, systolic_blood_pressure, diastolic_blood_pressure, heart_rate, temperature, medical_card_id)
VALUES
(CURDATE(), 130, 90, 80, 36.9, 1),
(CURDATE(), 120, 80, 60, 36.6, 2),
(CURDATE(), 135, 85, 90, 37.6, 3),
(CURDATE(), 140, 100, 70, 38.0, 4),
(CURDATE(), 125, 85, 85, 37.1, 5);

INSERT INTO patient(medical_card_id, hospital_id, doctor_personal_file_id)
VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);
