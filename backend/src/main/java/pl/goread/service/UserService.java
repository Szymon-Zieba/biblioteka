package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.goread.model.User;
import pl.goread.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG = "Nie znaleziono takiego użytkownika";

    private final UserRepository userRepository;

    public boolean emailExists(String email){
        return userRepository.existsUserByEmail(email);
    }

    public boolean PESELExists(String PESEL){
        return userRepository.existsUserByPESEL(PESEL);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND_MSG));
    }

    public User updateUser(User user, User updatedUser){
        BeanUtils.copyProperties(updatedUser, user);
        userRepository.save(user);
        return user;
    }
}
