package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.goread.repository.LibraryRepository;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

}
