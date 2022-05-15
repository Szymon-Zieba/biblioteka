package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.goread.model.PickUp;

import java.util.List;

@Repository
public interface PickUpRepository extends JpaRepository<PickUp, Long> {

    @Query(value = "SELECT * FROM pick_up p JOIN hire h ON p.hire_id=h.id WHERE p.id=:id",
            nativeQuery = true)
    List<PickUp> getPickUpById(@Param("id")Long id);
}
