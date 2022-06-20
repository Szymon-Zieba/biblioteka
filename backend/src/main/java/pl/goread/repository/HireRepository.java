package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Hire;
import pl.goread.model.Library;
import pl.goread.model.User;

import java.util.List;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long> {

    /**
     * Get all hires for a given library.
     *
     * @param library The library to get the hires from.
     * @return A list of Hires.
     */
    List<Hire> getHiresByLibrary(Library library);

    /**
     * Get all hires for a given user.
     *
     * @param user The user to get the hires for.
     * @return A list of Hires.
     */
    List<Hire> getHiresByUser(User user);
}
