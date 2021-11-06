package ua.lviv.iot.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.patient.Hospital;
import ua.lviv.iot.repository.patient.HospitalRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class HospitalService extends AbstractService<Hospital, Integer> {
    private final HospitalRepository hospitalRepository;

    @Override
    protected JpaRepository<Hospital, Integer> getRepository() {
        return hospitalRepository;
    }
}
