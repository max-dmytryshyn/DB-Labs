package ua.lviv.iot.controller.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.patient.Hospital;
import ua.lviv.iot.dto.patient.HospitalDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.patient.HospitalMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.patient.HospitalService;

@RequestMapping(value = "/hospitals")
@RestController
@AllArgsConstructor
public class HospitalController extends AbstractController<Hospital, HospitalDto, Integer> {
    private final HospitalService hospitalService;
    private final HospitalMapper hospitalMapper;

    @Override
    protected AbstractService<Hospital, Integer> getService() {
        return hospitalService;
    }

    @Override
    protected AbstractMapper<Hospital, HospitalDto> getMapper() {
        return hospitalMapper;
    }
}
