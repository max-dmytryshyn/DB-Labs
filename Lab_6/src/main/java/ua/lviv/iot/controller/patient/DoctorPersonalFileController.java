package ua.lviv.iot.controller.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.patient.DoctorPersonalFile;
import ua.lviv.iot.dto.patient.DoctorPersonalFileDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.patient.DoctorPersonalFileMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.patient.DoctorPersonalFileService;

@RequestMapping(value = "/doctor_personal_files")
@RestController
@AllArgsConstructor
public class DoctorPersonalFileController extends AbstractController<DoctorPersonalFile, DoctorPersonalFileDto, Integer> {
    private DoctorPersonalFileService doctorPersonalFileService;
    private DoctorPersonalFileMapper doctorPersonalFileMapper;

    @Override
    protected AbstractService<DoctorPersonalFile, Integer> getService() {
        return doctorPersonalFileService;
    }

    @Override
    protected AbstractMapper<DoctorPersonalFile, DoctorPersonalFileDto> getMapper() {
        return doctorPersonalFileMapper;
    }
}
