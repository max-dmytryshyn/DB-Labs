package ua.lviv.iot.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.patient.DoctorAppointment;

@Repository
public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Integer> {
}
