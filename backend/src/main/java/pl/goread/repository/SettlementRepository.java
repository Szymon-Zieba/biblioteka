package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.goread.model.GiveBack;
import pl.goread.model.Hire;
import pl.goread.model.Settlement;

import java.util.List;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {

    Settlement findSettlementByHire(Hire hire);

    @Query(value = "SELECT * FROM settlement s JOIN hire h ON s.hire_id=h.id WHERE h.user_id=:id",
            nativeQuery = true)
    List<Settlement> getSettlementsByUserId(@Param("id")Long id);
}
