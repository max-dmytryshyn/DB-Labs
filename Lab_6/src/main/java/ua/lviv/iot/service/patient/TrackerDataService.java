package ua.lviv.iot.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.patient.TrackerData;
import ua.lviv.iot.repository.patient.TrackerDataRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class TrackerDataService extends AbstractService<TrackerData, Integer> {
    private final TrackerDataRepository trackerDataRepository;

    @Override
    protected JpaRepository<TrackerData, Integer> getRepository() {
        return trackerDataRepository;
    }
}
