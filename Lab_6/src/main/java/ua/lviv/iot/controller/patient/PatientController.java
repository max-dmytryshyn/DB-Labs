package ua.lviv.iot.controller.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.patient.Patient;
import ua.lviv.iot.dto.patient.PatientDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.patient.PatientMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.patient.PatientService;

@RequestMapping(value = "/patients")
@RestController
@AllArgsConstructor
public class PatientController extends AbstractController<Patient, PatientDto, Integer> {
    private PatientService patientService;
    private PatientMapper patientMapper;

    @Override
    protected AbstractService<Patient, Integer> getService() {
        return patientService;
    }

    @Override
    protected AbstractMapper<Patient, PatientDto> getMapper() {
        return patientMapper;
    }
}
