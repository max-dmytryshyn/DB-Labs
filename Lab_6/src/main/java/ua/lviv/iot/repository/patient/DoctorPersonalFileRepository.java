package ua.lviv.iot.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.patient.DoctorPersonalFile;

@Repository
public interface DoctorPersonalFileRepository extends JpaRepository<DoctorPersonalFile, Integer> {
}
