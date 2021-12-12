package ua.lviv.iot.mapper.patient;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.patient.DoctorAppointment;
import ua.lviv.iot.dto.patient.DoctorAppointmentDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class DoctorAppointmentMapper extends AbstractMapper<DoctorAppointment, DoctorAppointmentDto> {

    @Override
    public DoctorAppointmentDto mapEntityToDto(DoctorAppointment doctorAppointment) {
        if (doctorAppointment == null)
            return null;

        DoctorAppointmentDto.DoctorAppointmentDtoBuilder doctorAppointmentDtoBuilder = DoctorAppointmentDto.builder();
        doctorAppointmentDtoBuilder.id(doctorAppointment.getId());
        doctorAppointmentDtoBuilder.date(doctorAppointment.getDate());
        doctorAppointmentDtoBuilder.recommendation(doctorAppointment.getRecommendation());
        doctorAppointmentDtoBuilder.doctorName(doctorAppointment.getDoctorPersonalFile().getName());
        doctorAppointmentDtoBuilder.doctorSurname(doctorAppointment.getDoctorPersonalFile().getSurname());
        doctorAppointmentDtoBuilder.patientName(doctorAppointment.getMedicalCard().getName());
        doctorAppointmentDtoBuilder.patientSurname(doctorAppointment.getMedicalCard().getSurname());

        return doctorAppointmentDtoBuilder.build();
    }
}
