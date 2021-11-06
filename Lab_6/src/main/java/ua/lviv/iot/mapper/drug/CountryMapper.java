package ua.lviv.iot.mapper.drug;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.drug.Country;
import ua.lviv.iot.dto.drug.CountryDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class CountryMapper extends AbstractMapper<Country, CountryDto> {

    @Override
    public CountryDto mapEntityToDto(Country country) {
        if (country == null)
            return null;

        CountryDto.CountryDtoBuilder countryDtoBuilder = CountryDto.builder();
        countryDtoBuilder.id(country.getId());
        countryDtoBuilder.name(country.getName());

        return countryDtoBuilder.build();
    }
}
