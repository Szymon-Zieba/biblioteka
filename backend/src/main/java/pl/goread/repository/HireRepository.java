package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.goread.model.Hire;
import pl.goread.model.Library;
import pl.goread.model.User;

import java.util.List;

public interface HireRepository extends JpaRepository<Hire, Long> {

    List<Hire> getHiresByLibrary(Library library);

    List<Hire> getHiresByUser(User user);
}
