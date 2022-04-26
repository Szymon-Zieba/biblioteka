package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.goread.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
