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

    public Library getLibraryById(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(LIBRARY_NOT_FOUND_MSG));
    }

}
