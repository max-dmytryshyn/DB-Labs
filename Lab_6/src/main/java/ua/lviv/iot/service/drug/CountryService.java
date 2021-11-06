package ua.lviv.iot.service.drug;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.drug.Country;
import ua.lviv.iot.repository.drug.CountryRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class CountryService extends AbstractService<Country, Integer> {
    private final CountryRepository countryRepository;

    @Override
    protected JpaRepository<Country, Integer> getRepository() {
        return countryRepository;
    }
}
