package ua.lviv.iot.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.patient.DoctorAppointment;
import ua.lviv.iot.repository.patient.DoctorAppointmentRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class DoctorAppointmentService extends AbstractService<DoctorAppointment, Integer> {
    private final DoctorAppointmentRepository doctorAppointmentRepository;

    @Override
    protected JpaRepository<DoctorAppointment, Integer> getRepository() {
        return doctorAppointmentRepository;
    }
}
