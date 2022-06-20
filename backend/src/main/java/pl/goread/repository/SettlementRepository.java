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

    /**
     * Find the settlement for a given hire.
     *
     * @param hire The hire object that you want to find the settlement for.
     * @return A Settlement object.
     */
    Settlement findSettlementByHire(Hire hire);

    /**
     * Get all settlements for a given user id.
     *
     * @param id ID of the user to get the settlements for.
     * @return A list of Settlements.
     */
    @Query(value = "SELECT * FROM settlement s JOIN hire h ON s.hire_id=h.id WHERE h.user_id=:id",
            nativeQuery = true)
    List<Settlement> getSettlementsByUserId(@Param("id")Long id);
}
