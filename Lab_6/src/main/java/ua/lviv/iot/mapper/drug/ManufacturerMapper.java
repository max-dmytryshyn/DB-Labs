package ua.lviv.iot.mapper.drug;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.drug.Manufacturer;
import ua.lviv.iot.dto.drug.ManufacturerDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class ManufacturerMapper extends AbstractMapper<Manufacturer, ManufacturerDto> {

    @Override
    public ManufacturerDto mapEntityToDto(Manufacturer manufacturer) {
        if (manufacturer == null)
            return null;

        ManufacturerDto.ManufacturerDtoBuilder manufacturerDtoBuilder = ManufacturerDto.builder();
        manufacturerDtoBuilder.id(manufacturer.getId());
        manufacturerDtoBuilder.name(manufacturer.getName());
        manufacturerDtoBuilder.country(manufacturer.getCountry().getName());

        return manufacturerDtoBuilder.build();
    }
}
