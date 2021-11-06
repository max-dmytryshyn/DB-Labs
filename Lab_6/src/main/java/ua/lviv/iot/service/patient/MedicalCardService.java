package ua.lviv.iot.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.patient.MedicalCard;
import ua.lviv.iot.repository.patient.MedicalCardRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class MedicalCardService extends AbstractService<MedicalCard, Integer> {
    private final MedicalCardRepository medicalCardRepository;

    @Override
    protected JpaRepository<MedicalCard, Integer> getRepository() {
        return medicalCardRepository;
    }
}
