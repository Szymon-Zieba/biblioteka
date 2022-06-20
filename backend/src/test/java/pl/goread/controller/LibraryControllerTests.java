package pl.goread.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.goread.model.*;
import pl.goread.repository.LibraryRepository;
import pl.goread.security.jwt.JWTUtils;
import pl.goread.service.LibraryService;
import pl.goread.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryController.class)
public class LibraryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryRepository repository;

    @MockBean
    private LibraryService service;

    @MockBean
    private UserService userService;

    @MockBean
    private JWTUtils jwtUtils;

    @Test
    public void getLibraries() throws Exception {
        Library library = new Library();
        library.setId((long)1);
        library.setCity("Miasto");
        library.setPostCode("30-300");
        library.setEmail("Email");
        library.setPhoneNumber("Email");
        library.setStreetAndNumber("ulica i numer 13");

        Library library2 = new Library();
        library2.setId((long)1);
        library2.setCity("Miasto");
        library2.setPostCode("30-300");
        library2.setEmail("Email");
        library2.setPhoneNumber("Email");
        library2.setStreetAndNumber("ulica i numer 13");

        List<Library> libraryList = new ArrayList<>();
        libraryList.add(library);
        libraryList.add(library2);

        Mockito.when(repository.findAll()).thenReturn(libraryList);
        String url = "/libraries";

        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }
}
