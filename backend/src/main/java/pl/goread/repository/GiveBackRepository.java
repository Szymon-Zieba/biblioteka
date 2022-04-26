package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.GiveBack;
import pl.goread.model.Hire;
import pl.goread.model.User;

import java.util.List;

@Repository
public interface GiveBackRepository extends JpaRepository<GiveBack, Long> {

    List<GiveBack> getGivesBackByHire(Hire hire);

    List<GiveBack> getGiveBackByEmployee(User user);
}
