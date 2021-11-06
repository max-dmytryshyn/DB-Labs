package ua.lviv.iot.controller.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.patient.DoctorAppointment;
import ua.lviv.iot.dto.patient.DoctorAppointmentDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.patient.DoctorAppointmentMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.patient.DoctorAppointmentService;

@RequestMapping(value = "/doctor_appointments")
@RestController
@AllArgsConstructor
public class DoctorAppointmentController extends AbstractController<DoctorAppointment, DoctorAppointmentDto, Integer> {
    private final DoctorAppointmentService doctorAppointmentService;
    private final DoctorAppointmentMapper doctorAppointmentMapper;

    @Override
    protected AbstractService<DoctorAppointment, Integer> getService() {
        return doctorAppointmentService;
    }

    @Override
    protected AbstractMapper<DoctorAppointment, DoctorAppointmentDto> getMapper() {
        return doctorAppointmentMapper;
    }
}
