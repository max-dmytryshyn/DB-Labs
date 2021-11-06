package ua.lviv.iot.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.patient.TrackerData;

@Repository
public interface TrackerDataRepository extends JpaRepository<TrackerData, Integer> {
}
