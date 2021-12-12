package ua.lviv.iot.controller.drug;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.drug.Country;
import ua.lviv.iot.dto.drug.CountryDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.drug.CountryMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.drug.CountryService;

@RequestMapping(value = "/countries")
@RestController
@AllArgsConstructor
public class CountryController extends AbstractController<Country, CountryDto, Integer> {
    private final CountryService countryService;
    private final CountryMapper countryMapper;

    @Override
    protected AbstractService<Country, Integer> getService() {
        return countryService;
    }

    @Override
    protected AbstractMapper<Country, CountryDto> getMapper() {
        return countryMapper;
    }
}
