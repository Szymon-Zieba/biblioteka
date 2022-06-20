package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.goread.model.User;
import pl.goread.repository.RoleRepository;
import pl.goread.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG = "Nie znaleziono takiego użytkownika";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /**
     * If a user exists with the given email, return true, otherwise return false.
     *
     * @param email The email address to check.
     * @return A boolean value.
     */
    public boolean emailExists(String email) {
        return userRepository.existsUserByEmail(email);
    }

    /**
     * If the user exists, return true, otherwise return false.
     *
     * @param PESEL The PESEL number of the user.
     * @return boolean
     */
    public boolean PESELExists(String PESEL) {
        return userRepository.existsUserByPESEL(PESEL);
    }

    @Override
    // A method from the UserDetailsService interface. It is used by Spring Security to authenticate the user.
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }

    /**
     * If the user is found, return it, otherwise throw an exception.
     *
     * @param id The id of the user to be retrieved.
     * @return A user object
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND_MSG));
    }

    /**
     * Copy the properties of the updatedUser object into the user object, then save the user object.
     *
     * @param user        The user object that is being updated.
     * @param updatedUser The updated user object that contains the new values.
     * @return The updated user.
     */
    public User updateUser(User user, User updatedUser) {
        BeanUtils.copyProperties(updatedUser, user);
        userRepository.save(user);
        return user;
    }

    /**
     * The function takes a user object, sets the role of the user to the role object that has the same name as the role
     * name of the user object, and then saves the user object to the database
     *
     * @param user The user object that is being passed in from the front end.
     * @return The user object is being returned.
     */
    public User addEmployee(User user) {

        user.setRole(roleRepository.findRoleByName(user.getRole().getName()));
        return userRepository.save(user);
    }

    /**
     * This function sets the enabled status of a user to the status passed in as a parameter.
     *
     * @param user   The user object that is being updated.
     * @param status true or false
     * @return The user object is being returned.
     */
    public User setEnableAccount(User user, boolean status) {
        user.setEnabled(status);
        userRepository.save(user);
        return user;
    }

}
