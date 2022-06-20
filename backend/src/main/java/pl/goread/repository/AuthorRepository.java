package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    /**
     * Find an author by name and last name.
     *
     * @param name     The name of the author
     * @param lastName The last name of the author.
     * @return A list of authors
     */
    Author findByNameAndLastName(String name, String lastName);

    /**
     * Returns true if there is an author with the given name and last name.
     *
     * @param name     The name of the author
     * @param lastName The last name of the author.
     * @return boolean
     */
    boolean existsAuthorByNameAndLastName(String name, String lastName);
}
