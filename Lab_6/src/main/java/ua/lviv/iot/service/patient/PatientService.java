package ua.lviv.iot.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.patient.Patient;
import ua.lviv.iot.repository.patient.PatientRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class PatientService extends AbstractService<Patient, Integer> {
    private final PatientRepository patientRepository;

    @Override
    protected JpaRepository<Patient, Integer> getRepository() {
        return patientRepository;
    }
}
