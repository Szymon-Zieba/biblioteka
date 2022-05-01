package pl.goread.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Author;
import pl.goread.model.Category;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByNameAndLastName(String name, String lastName) ;
    boolean existsAuthorByNameAndLastName(String name, String lastName);
}
