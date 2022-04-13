package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean emailExists(String email){
        return userRepository.existsUserByEmail(email);
    }

    public boolean PESELExists(String PESEL){
        return userRepository.existsUserByPESEL(PESEL);
    }

}
