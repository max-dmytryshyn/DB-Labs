package ua.lviv.iot.mapper.drug;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.drug.Drug;
import ua.lviv.iot.dto.drug.DrugDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class DrugMapper extends AbstractMapper<Drug, DrugDto> {

    @Override
    public DrugDto mapEntityToDto(Drug drug) {
        if (drug == null)
            return null;

        DrugDto.DrugDtoBuilder drugDtoBuilder = DrugDto.builder();
        drugDtoBuilder.id(drug.getId());
        drugDtoBuilder.name(drug.getName());
        drugDtoBuilder.price(drug.getPrice());
        drugDtoBuilder.manufacturerName(drug.getManufacturer().getName());
        drugDtoBuilder.country(drug.getManufacturer().getCountry().getName());

        return drugDtoBuilder.build();
    }
}
