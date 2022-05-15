package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.goread.model.GiveBack;
import pl.goread.model.Hire;
import pl.goread.model.User;
import pl.goread.service.GiveBackService;

import java.util.List;

@Repository
public interface GiveBackRepository extends JpaRepository<GiveBack, Long> {

    List<GiveBack> getGivesBackByHire(Hire hire);

    List<GiveBack> getGiveBackByEmployee(User user);

    @Query(value = "SELECT * FROM give_back g JOIN hire h ON g.hire_id=h.id WHERE h.user_id=:id",
            nativeQuery = true)
    List<GiveBack> getGiveBacksByUserId(@Param("id")Long id);
}
