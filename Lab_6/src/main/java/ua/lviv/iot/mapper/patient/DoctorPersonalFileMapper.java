package ua.lviv.iot.mapper.patient;

import ua.lviv.iot.domain.patient.DoctorPersonalFile;
import ua.lviv.iot.dto.patient.DoctorPersonalFileDto;
import ua.lviv.iot.mapper.AbstractMapper;

public class DoctorPersonalFileMapper extends AbstractMapper<DoctorPersonalFile, DoctorPersonalFileDto> {

    @Override
    public DoctorPersonalFileDto mapEntityToDto(DoctorPersonalFile doctorPersonalFile) {
        if (doctorPersonalFile == null)
            return null;

        DoctorPersonalFileDto.DoctorPersonalFileDtoBuilder doctorPersonalFileDtoBuilder = DoctorPersonalFileDto.builder();
        doctorPersonalFileDtoBuilder.id(doctorPersonalFile.getId());
        doctorPersonalFileDtoBuilder.name(doctorPersonalFile.getName());
        doctorPersonalFileDtoBuilder.surname(doctorPersonalFile.getSurname());
        doctorPersonalFileDtoBuilder.hospitalName(doctorPersonalFile.getHospital().getName());

        return doctorPersonalFileDtoBuilder.build();
    }
}
