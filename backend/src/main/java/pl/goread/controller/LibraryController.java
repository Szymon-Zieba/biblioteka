package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.Library;
import pl.goread.repository.LibraryRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryRepository libraryRepository;

    @GetMapping("/libraries")
    public List<Library> getLibraries(){
        return libraryRepository.findAll();
    }

    @PostMapping("/library")
    public Library addLibrary(@RequestBody Library library){
        return libraryRepository.save(library);
    }
}
