package ua.lviv.iot.service.drug;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.drug.Manufacturer;
import ua.lviv.iot.repository.drug.ManufacturerRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class ManufacturerService extends AbstractService<Manufacturer, Integer> {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    protected JpaRepository<Manufacturer, Integer> getRepository() {
        return manufacturerRepository;
    }
}
