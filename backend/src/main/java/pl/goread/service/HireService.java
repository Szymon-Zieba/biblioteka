package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.*;
import pl.goread.model.enums.DemandBookStatus;
import pl.goread.repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HireService {

    private static final String USER_NOT_FOUND_MSG = "Nie znaleziono takiego wypożyczenia";

    private final HireRepository HireRepository;

    public List<Hire> getHiresByLibrary(Library library) {
        return HireRepository.getHiresByLibrary(library);
    }

    public List<Hire> getHiresByUser(User user) {
        return HireRepository.getHiresByUser(user);
    }

    public final UserService userService;

    public final LibraryService libraryService;

    public Hire getHireById(Long id) {
        return HireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND_MSG));
    }

    public Hire addHire(Hire hire) {
        return HireRepository.save(hire);
    }

    public List<Hire> getHiresByUserId(Long id) {
        return HireRepository.getHiresByUser(userService.getUserById(id));
    }

    public List<Hire> getHiresByLibraryId(Long id) {
        return HireRepository.getHiresByLibrary(libraryService.getLibraryById(id));
    }

    public void updateHire(Long id, String status){
        Hire hire = HireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND_MSG));
        System.out.println(HireRepository.findById(id));
        hire.setStatus(DemandBookStatus.valueOf(status));
        System.out.println(hire.getStatus());

        HireRepository.save(hire);
    }
}
