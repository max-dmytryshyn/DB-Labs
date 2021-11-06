package ua.lviv.iot.mapper.patient;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.patient.MedicalCard;
import ua.lviv.iot.dto.patient.MedicalCardDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class MedicalCardMapper extends AbstractMapper<MedicalCard, MedicalCardDto> {

    @Override
    public MedicalCardDto mapEntityToDto(MedicalCard medicalCard) {
        if (medicalCard == null)
            return null;

        MedicalCardDto.MedicalCardDtoBuilder medicalCardDtoBuilder = MedicalCardDto.builder();
        medicalCardDtoBuilder.id(medicalCard.getId());
        medicalCardDtoBuilder.name(medicalCard.getName());
        medicalCardDtoBuilder.surname(medicalCard.getSurname());
        medicalCardDtoBuilder.birthDate(medicalCard.getBirthDate());

        return medicalCardDtoBuilder.build();
    }
}
