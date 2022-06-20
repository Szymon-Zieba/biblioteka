package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.goread.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by email.
     *
     * @param email The email address of the user to find.
     * @return User object
     */
    User findUserByEmail(String email);

    /**
     * Find a user by PESEL.
     *
     * @param PESEL The PESEL number of the user you want to find.
     * @return User
     */
    User findUserByPESEL(String PESEL);

    /**
     * Returns true if a user with the given email exists in the database.
     *
     * @param email The email address of the user.
     * @return A boolean value.
     */
    boolean existsUserByEmail(String email);

    /**
     * Returns true if there is a user with the given PESEL, false otherwise.
     *
     * @param PESEL PESEL number of the user
     * @return boolean
     */
    boolean existsUserByPESEL(String PESEL);

    /**
     * Get all employees.
     *
     * @return A list of Users who are Employees.
     */
    @Query(value = "SELECT * FROM User where role_id!=1",
            nativeQuery = true)
    List<User> getEmployees();

    /**
     * Get employee by given id.
     *
     * @param id Id of the employee to find
     * @return A User object who is Employee.
     */
    @Query(value = "SELECT * FROM User where role_id!=1 && id=:id",
            nativeQuery = true)
    User getEmployeeById(@Param("id")Long id);

}
