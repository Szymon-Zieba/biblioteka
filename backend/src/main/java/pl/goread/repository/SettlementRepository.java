package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Hire;
import pl.goread.model.Settlement;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {

    Hire findSettlementByHire(Hire hire);

}
