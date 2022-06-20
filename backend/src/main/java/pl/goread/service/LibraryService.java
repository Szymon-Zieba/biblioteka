package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Library;
import pl.goread.repository.LibraryRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private static final String LIBRARY_NOT_FOUND_MSG = "Nie znaleziono takiej biblioteki";

    private final LibraryRepository libraryRepository;

    /**
     * If the library exists, return it, otherwise throw an exception.
     *
     * @param id The id of the library to be retrieved.
     * @return A Library object
     */
    public Library getLibraryById(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(LIBRARY_NOT_FOUND_MSG));
    }

}
