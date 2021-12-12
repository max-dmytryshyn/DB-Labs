package ua.lviv.iot.controller.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.domain.patient.TrackerData;
import ua.lviv.iot.dto.patient.TrackerDataDto;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.patient.TrackerDataMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.patient.TrackerDataService;

@RequestMapping(value = "/tracker_data")
@RestController
@AllArgsConstructor
public class TrackerDataController extends AbstractController<TrackerData, TrackerDataDto, Integer> {
    private TrackerDataService trackerDataService;
    private TrackerDataMapper trackerDataMapper;

    @Override
    protected AbstractService<TrackerData, Integer> getService() {
        return trackerDataService;
    }

    @Override
    protected AbstractMapper<TrackerData, TrackerDataDto> getMapper() {
        return trackerDataMapper;
    }
}
