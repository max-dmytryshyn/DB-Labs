package ua.lviv.iot.mapper.patient;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.patient.Patient;
import ua.lviv.iot.dto.patient.PatientDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class PatientMapper extends AbstractMapper<Patient, PatientDto> {

    @Override
    public PatientDto mapEntityToDto(Patient patient) {
        if (patient == null)
            return null;

        PatientDto.PatientDtoBuilder patientDtoBuilder = PatientDto.builder();
        patientDtoBuilder.id(patient.getId());
        patientDtoBuilder.name(patient.getMedicalCard().getName());
        patientDtoBuilder.surname(patient.getMedicalCard().getSurname());
        patientDtoBuilder.hospitalName(patient.getHospital().getName());
        patientDtoBuilder.doctorName(patient.getDoctorPersonalFile().getName());
        patientDtoBuilder.doctorSurname(patient.getDoctorPersonalFile().getSurname());

        return patientDtoBuilder.build();
    }
}
