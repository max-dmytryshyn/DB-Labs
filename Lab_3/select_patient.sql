SELECT mc.name, mc.surname, mc.birth_date, h.name AS hospital_name, h.adress AS hospital_adress, 
	dpf.name AS doctor_name, dpf.surname AS doctor_surname,mc.tracker_date, mc.systolic_blood_pressure,
    mc.diastolic_blood_pressure, mc.heart_rate, mc.temperature, mc.doctor_appointment_date, mc.recomendation,
    mc.drugs
    FROM patient
INNER JOIN doctor_personal_file AS dpf ON patient.doctor_personal_file_id = dpf.id
INNER JOIN hospital AS h ON patient.hospital_id = h.id
INNER JOIN 
	(SELECT mc.id, mc.name, mc.surname, mc.birth_date, td.date AS tracker_date, td.systolic_blood_pressure,
    td.diastolic_blood_pressure, td.heart_rate, td.temperature, da.date AS doctor_appointment_date, da.recomendation,
    da.drugs
    FROM medical_card AS mc
    INNER JOIN tracker_data AS td ON mc.id = td.medical_card_id
    INNER JOIN
    (SELECT da.date, da.recomendation, da.medical_card_id, dahd.drugs FROM doctor_appointment AS da
		INNER JOIN(
			SELECT dahd.doctor_appointment_id, GROUP_CONCAT(d.name SEPARATOR ', ') AS drugs
			FROM doctor_appointment_has_drug AS dahd
			INNER JOIN (
            SELECT d.id, CONCAT(d.name, "(", m.name, ")") AS name FROM drug AS d
            INNER JOIN manufacturer AS m ON d.manufacturer_id = m.id
            ) AS d 
            ON dahd.drug_id = d.id 
			GROUP BY dahd.doctor_appointment_id) AS dahd
		ON da.id = dahd.doctor_appointment_id) AS da
    ON mc.id = da.medical_card_id) AS mc
ON patient.medical_card_id = mc.id


