package ua.lviv.iot.mapper.patient;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.patient.TrackerData;
import ua.lviv.iot.dto.patient.TrackerDataDto;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class TrackerDataMapper extends AbstractMapper<TrackerData, TrackerDataDto> {

    @Override
    public TrackerDataDto mapEntityToDto(TrackerData trackerData) {
        if (trackerData == null)
            return null;

        TrackerDataDto.TrackerDataDtoBuilder trackerDataDtoBuilder = TrackerDataDto.builder();
        trackerDataDtoBuilder.id(trackerData.getId());
        trackerDataDtoBuilder.date(trackerData.getDate());
        trackerDataDtoBuilder.systolicBloodPressure(trackerData.getSystolicBloodPressure());
        trackerDataDtoBuilder.diastolicBloodPressure(trackerData.getDiastolicBloodPressure());
        trackerDataDtoBuilder.heartRate(trackerData.getHeartRate());
        trackerDataDtoBuilder.temperature(trackerData.getTemperature());
        trackerDataDtoBuilder.patientName(trackerData.getMedicalCard().getName());
        trackerDataDtoBuilder.patientSurname(trackerData.getMedicalCard().getSurname());

        return trackerDataDtoBuilder.build();
    }
}
