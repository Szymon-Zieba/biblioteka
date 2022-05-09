package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.goread.model.*;
import pl.goread.repository.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HireService {

    private static final String USER_NOT_FOUND_MSG = "Nie znaleziono takiego wypożyczenia";

    private final HireRepository HireRepository;


    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final LibraryRepository libraryRepository;

    private final BookRepository bookRepository;

    private final Book book;
    private final Library library;

    public List<Hire> getHiresByLibrary(Library library){
        return HireRepository.getHiresByLibrary(library);
    }

    public List<Hire> getHiresByUser(User user){
        return HireRepository.getHiresByUser(user);
    }

    public Hire getHireById(Long id){
        return HireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND_MSG));
    }

    public Hire addHire(Hire hire){
        return HireRepository.save(hire);
    }


}
