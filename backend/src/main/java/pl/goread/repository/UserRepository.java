package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.goread.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserByPESEL(String PESEL);

    boolean existsUserByEmail(String email);

    boolean existsUserByPESEL(String PESEL);

    //Przy zalozeniu, ze ROLE_USER ma id=0
    @Query(value = "SELECT * FROM User where role_id!=0",
            nativeQuery = true)
    List<User> getEmployees();

}
