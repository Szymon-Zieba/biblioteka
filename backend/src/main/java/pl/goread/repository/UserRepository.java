package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserByPESEL(String PESEL);

    boolean existsUserByEmail(String email);

    boolean existsUserByPESEL(String PESEL);
}
