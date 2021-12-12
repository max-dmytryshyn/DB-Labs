package ua.lviv.iot.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.patient.DoctorPersonalFile;
import ua.lviv.iot.repository.patient.DoctorPersonalFileRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class DoctorPersonalFileService extends AbstractService<DoctorPersonalFile, Integer> {
    private final DoctorPersonalFileRepository doctorPersonalFileRepository;

    @Override
    protected JpaRepository<DoctorPersonalFile, Integer> getRepository() {
        return doctorPersonalFileRepository;
    }
}
