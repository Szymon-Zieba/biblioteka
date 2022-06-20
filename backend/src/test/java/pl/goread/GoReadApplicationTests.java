package pl.goread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.goread.controller.*;
import pl.goread.repository.*;
import pl.goread.security.WebSecurityConfig;
import pl.goread.security.jwt.AuthEntryPoint;
import pl.goread.security.jwt.AuthTokenFilter;
import pl.goread.security.jwt.JWTUtils;
import pl.goread.service.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GoReadApplicationTests {

    //REPOSITORIES

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GiveBackRepository giveBackRepository;
    @Autowired
    HireRepository hireRepository;
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    PublishmentHouseRepository publishmentHouseRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SettlementRepository settlementRepository;
    @Autowired
    UserRepository userRepository;

    //SERVICES

    @Autowired
    BookService bookService;
    @Autowired
    GiveBackService giveBackService;
    @Autowired
    HireService hireService;
    @Autowired
    LibraryService libraryService;
    @Autowired
    SettlementService settlementService;
    @Autowired
    UserService userService;

    //CONTROLLERS

    @Autowired
    AuthController authController;
    @Autowired
    BookController bookController;
    @Autowired
    EmployeeController employeeController;
    @Autowired
    GiveBackController giveBackController;
    @Autowired
    HireController hireController;
    @Autowired
    LibraryController libraryController;
    @Autowired
    SettlementController settlementController;
    @Autowired
    UserController userController;

    //SECURITY

    @Autowired
    AuthEntryPoint authEntryPoint;
    @Autowired
    AuthTokenFilter authTokenFilter;
    @Autowired
    JWTUtils jwtUtils;
    @Autowired
    WebSecurityConfig webSecurityConfig;

    @Test
    void contextLoads() {
        assertThat(authorRepository).isNotNull();
        assertThat(bookRepository).isNotNull();
        assertThat(categoryRepository).isNotNull();
        assertThat(giveBackRepository).isNotNull();
        assertThat(hireRepository).isNotNull();
        assertThat(libraryRepository).isNotNull();
        assertThat(publishmentHouseRepository).isNotNull();
        assertThat(roleRepository).isNotNull();
        assertThat(settlementRepository).isNotNull();
        assertThat(userRepository).isNotNull();

        assertThat(bookService).isNotNull();
        assertThat(giveBackService).isNotNull();
        assertThat(hireService).isNotNull();
        assertThat(libraryService).isNotNull();
        assertThat(settlementService).isNotNull();
        assertThat(userService).isNotNull();

        assertThat(authController).isNotNull();
        assertThat(bookController).isNotNull();
        assertThat(employeeController).isNotNull();
        assertThat(giveBackController).isNotNull();
        assertThat(hireController).isNotNull();
        assertThat(libraryController).isNotNull();
        assertThat(settlementController).isNotNull();
        assertThat(userController).isNotNull();

        assertThat(authEntryPoint).isNotNull();
        assertThat(authTokenFilter).isNotNull();
        assertThat(jwtUtils).isNotNull();
        assertThat(webSecurityConfig).isNotNull();
    }

}
