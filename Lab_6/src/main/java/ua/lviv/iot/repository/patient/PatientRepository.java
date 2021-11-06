package ua.lviv.iot.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.patient.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
