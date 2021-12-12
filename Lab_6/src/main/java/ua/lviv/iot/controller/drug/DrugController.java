package ua.lviv.iot.controller.drug;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.drug.Drug;
import ua.lviv.iot.dto.drug.DrugDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.drug.DrugMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.drug.DrugService;

@RequestMapping(value = "/drugs")
@RestController
@AllArgsConstructor
public class DrugController extends AbstractController<Drug, DrugDto, Integer> {
    private final DrugService drugService;
    private final DrugMapper drugMapper;

    @Override
    protected AbstractService<Drug, Integer> getService() {
        return drugService;
    }

    @Override
    protected AbstractMapper<Drug, DrugDto> getMapper() {
        return drugMapper;
    }
}
