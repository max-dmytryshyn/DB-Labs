package ua.lviv.iot.repository.drug;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.drug.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer> {
}
