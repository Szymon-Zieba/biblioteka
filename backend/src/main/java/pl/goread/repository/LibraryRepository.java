package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.goread.model.Library;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    /**
     * Get all libraries for a given employee id.
     *
     * @param id ID of the employee to get the libraries for.
     * @return A list of Libraries.
     */
    @Query(value = "SELECT * FROM library l JOIN library_users lu ON l.id=lu.library_id WHERE lu.users_id=:id",
            nativeQuery = true)
    List<Library> getLibrariesUser(@Param("id") Long id);
}
