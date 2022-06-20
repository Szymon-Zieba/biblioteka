package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Hire;
import pl.goread.model.Library;
import pl.goread.model.User;
import pl.goread.model.enums.DemandBookStatus;
import pl.goread.repository.HireRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HireService {

    private static final String USER_NOT_FOUND_MSG = "Nie znaleziono takiego wypożyczenia";

    private final HireRepository HireRepository;

    /**
     * This function returns a list of hires by library.
     *
     * @param library The library to get the hires from.
     * @return A list of Hires
     */
    public List<Hire> getHiresByLibrary(Library library) {
        return HireRepository.getHiresByLibrary(library);
    }

    /**
     * This function returns a list of hires for a given user.
     *
     * @param user The user object that you want to get the hires for.
     * @return A list of Hires
     */
    public List<Hire> getHiresByUser(User user) {
        return HireRepository.getHiresByUser(user);
    }

    public final UserService userService;

    public final LibraryService libraryService;

    /**
     * If the hire exists, return it, otherwise throw an exception.
     *
     * @param id The id of the hire to be retrieved.
     * @return The hire object with the id that was passed in.
     */
    public Hire getHireById(Long id) {
        return HireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND_MSG));
    }

    /**
     * This function adds a hire to the database.
     *
     * @param hire The hire object that we want to add to the database.
     * @return The hire object is being returned.
     */
    public Hire addHire(Hire hire) {
        return HireRepository.save(hire);
    }

    /**
     * "Get all the hires for a user."
     *
     * The first thing we do is get the user by their id. Then we get all the hires for that user
     *
     * @param id The id of the user
     * @return A list of Hires
     */
    public List<Hire> getHiresByUserId(Long id) {
        return HireRepository.getHiresByUser(userService.getUserById(id));
    }

    /**
     * Get all the hires for a library.
     *
     * @param id The id of the library
     * @return A list of Hires
     */
    public List<Hire> getHiresByLibraryId(Long id) {
        return HireRepository.getHiresByLibrary(libraryService.getLibraryById(id));
    }

    /**
     * It takes the id of a hire and a status as a string, finds the hire in the database, sets the status of the hire to
     * the status passed in, and saves the hire
     *
     * @param id the id of the hire
     * @param status the status of the demand book
     */
    public void updateHire(Long id, String status) {
        Hire hire = HireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND_MSG));
        System.out.println(HireRepository.findById(id));
        hire.setStatus(DemandBookStatus.valueOf(status));
        System.out.println(hire.getStatus());

        HireRepository.save(hire);
    }
}
