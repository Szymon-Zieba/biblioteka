package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.Library;
import pl.goread.model.User;
import pl.goread.repository.LibraryRepository;
import pl.goread.service.LibraryService;

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

    @GetMapping("/libraries/user/{id}")
    public List<Library> getLibrariesUser(@PathVariable Long id){
        return libraryRepository.getLibrariesUser(id);
    }

    @PostMapping("/library")
    public Library addLibrary(@RequestBody Library library){
        System.out.println(library);
        return libraryRepository.save(library);
    }

    @DeleteMapping("/library/{id}")
    public void deleteLibrary(@PathVariable Long id){
        libraryRepository.delete(libraryRepository.getById(id));
    }
}
