package ua.lviv.iot.controller.drug;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.drug.Manufacturer;
import ua.lviv.iot.dto.drug.ManufacturerDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.drug.ManufacturerMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.drug.ManufacturerService;

@RequestMapping(value = "/manufacturers")
@RestController
@AllArgsConstructor
public class ManufacturerController extends AbstractController<Manufacturer, ManufacturerDto, Integer> {
    private ManufacturerService manufacturerService;
    private ManufacturerMapper manufacturerMapper;

    @Override
    protected AbstractService<Manufacturer, Integer> getService() {
        return manufacturerService;
    }

    @Override
    protected AbstractMapper<Manufacturer, ManufacturerDto> getMapper() {
        return manufacturerMapper;
    }
}
