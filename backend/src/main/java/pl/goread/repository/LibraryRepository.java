package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
