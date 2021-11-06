package ua.lviv.iot.service.drug;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.drug.Drug;
import ua.lviv.iot.repository.drug.DrugRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class DrugService extends AbstractService<Drug, Integer> {
    private final DrugRepository drugRepository;

    @Override
    protected JpaRepository<Drug, Integer> getRepository() {
        return drugRepository;
    }
}
