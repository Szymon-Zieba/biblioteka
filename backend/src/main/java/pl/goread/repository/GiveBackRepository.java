package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.goread.model.GiveBack;
import pl.goread.model.Hire;
import pl.goread.model.User;

import java.util.List;

@Repository
public interface GiveBackRepository extends JpaRepository<GiveBack, Long> {

    /**
     * Get all the give backs for a hire.
     *
     * @param hire the hire object that you want to get the give backs for.
     * @return A list of GiveBack objects.
     */
    List<GiveBack> getGivesBackByHire(Hire hire);

    /**
     * Get all the give backs for a given employee.
     *
     * @param user The user object that you want to get the givebacks for.
     * @return A list of GiveBack objects.
     */
    List<GiveBack> getGiveBackByEmployee(User user);

    /**
     * Get all the give backs for a given user id.
     *
     * @param id ID of the user that you want to get the givebacks for.
     * @return A list of GiveBack objects.
     */
    @Query(value = "SELECT * FROM give_back g JOIN hire h ON g.hire_id=h.id WHERE h.user_id=:id",
            nativeQuery = true)
    List<GiveBack> getGiveBacksByUserId(@Param("id") Long id);
}
