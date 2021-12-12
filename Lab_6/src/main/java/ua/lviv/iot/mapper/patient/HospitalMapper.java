package ua.lviv.iot.mapper.patient;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.patient.Hospital;
import ua.lviv.iot.dto.patient.HospitalDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class HospitalMapper extends AbstractMapper<Hospital, HospitalDto> {

    @Override
    public HospitalDto mapEntityToDto(Hospital hospital) {
        if (hospital == null)
            return null;

        HospitalDto.HospitalDtoBuilder hospitalDtoBuilder = HospitalDto.builder();
        hospitalDtoBuilder.id(hospital.getId());
        hospitalDtoBuilder.name(hospital.getName());
        hospitalDtoBuilder.address(hospital.getAddress());

        return hospitalDtoBuilder.build();
    }
}
