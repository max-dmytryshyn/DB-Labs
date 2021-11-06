package ua.lviv.iot.controller.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.patient.MedicalCard;
import ua.lviv.iot.dto.patient.MedicalCardDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.patient.MedicalCardMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.patient.MedicalCardService;

@RequestMapping(value = "/medical_cards")
@RestController
@AllArgsConstructor
public class MedicalCardController extends AbstractController<MedicalCard, MedicalCardDto, Integer> {
    private MedicalCardService medicalCardService;
    private MedicalCardMapper medicalCardMapper;

    @Override
    protected AbstractService<MedicalCard, Integer> getService() {
        return  medicalCardService;
    }

    @Override
    protected AbstractMapper<MedicalCard, MedicalCardDto> getMapper() {
        return medicalCardMapper;
    }
}
