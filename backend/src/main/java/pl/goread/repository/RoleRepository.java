package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Find a role by name.
     *
     * @param name The name of the role to find.
     * @return A Role object
     */
    Role findRoleByName(String name);

    /**
     * Returns true if there is a user with the given name.
     *
     * @param name The name of the user to check for.
     * @return A boolean value.
     */
    boolean existsByName(String name);
}
