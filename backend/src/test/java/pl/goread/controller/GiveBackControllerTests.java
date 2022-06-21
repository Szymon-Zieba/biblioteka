package pl.goread.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.goread.model.*;
import pl.goread.model.enums.DemandBookStatus;
import pl.goread.repository.GiveBackRepository;
import pl.goread.security.jwt.JWTUtils;
import pl.goread.service.GiveBackService;
import pl.goread.service.UserService;

import java.time.LocalDateTime;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GiveBackController.class)
public class GiveBackControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GiveBackService service;

    @MockBean
    private GiveBackRepository repository;

    @MockBean
    private UserService userService;

    @MockBean
    private JWTUtils jwtUtils;

    @Test
    public void getEmployeeById() throws Exception {
        GiveBack giveBack = new GiveBack();

        giveBack.setId(1L);
            LocalDateTime dataTime = LocalDateTime.of(2000, 10, 1, 2, 32);
        giveBack.setReturnDate(dataTime);

            Hire hire = new Hire();
            hire.setId(1L);
                DemandBookStatus demandBookStatus = DemandBookStatus.HIRED;
            hire.setStatus(demandBookStatus);

            LocalDateTime dataTime12 = LocalDateTime.of(2000, 10, 1, 2, 32);
            hire.setHireDate(dataTime12);

                Author author = new Author();
                author.setId((long)1);
                author.setName("Imie");
                author.setLastName("Nazwisko");

                Author author2 = new Author();
                author2.setId((long)1);
                author2.setName("Imie2");
                author2.setLastName("Nazwisko2");
                Set<Author> authorList = new HashSet<>();
                authorList.add(author);
                authorList.add(author2);

                PublishmentHouse publishmentHouse = new PublishmentHouse();
                publishmentHouse.setId((long)1);
                publishmentHouse.setName("Wydawnictwo");

                Category category = new Category();
                category.setId((long)1);
                category.setName("Kategoria");

                DemandBookStatus demandBookStatus12 = DemandBookStatus.IN_STOCK;

                Library library = new Library();
                library.setId((long)1);
                library.setCity("Miasto");
                library.setPostCode("30-300");
                library.setEmail("Email");
                library.setPhoneNumber("Email");
                library.setStreetAndNumber("ulica i numer 13");
            hire.setLibrary(library);

            Book book = new Book();
            book.setId((long)1);
            book.setTitle("Tytuł");
            book.setAuthor(authorList);
            book.setPublishmentYear("2000");
            book.setPublishmentHouse(publishmentHouse);
            book.setCategory(category);
            book.setDescription("dsadsaasdsajkdhawkjfgqweifbewigfbewrohvbaerwiouvhrbsdjpikughfpseao;finhbseiughbwaesgovarheupbsrvou");
            book.setImgUrl("URL/RUD/SDAD");
            book.setStatus(demandBookStatus12);
            book.setLibrary(library);
            hire.setBook(book);

            Role role = new Role();
            role.setName("ROLE_EMPLOYEE");

            User user = new User();
            user.setRole(role);
            user.setLastName("Imie");
            user.setFirstName("Nazwisko");
            user.setZip("39-120");
            user.setEmail("email@com.com");
            user.setPhoneNumber("321312321");
            user.setPESEL("321312312321");
            user.setCity("Rzeszow");
            user.setEnabled(true);

            hire.setUser(user);
        giveBack.setHire(hire);

        giveBack.setEmployee(user);



        Mockito.when(repository.findById(giveBack.getId())).thenReturn(Optional.of(giveBack));
        String url = "/giveback/" + giveBack.getId();

        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getGiveBacksByUserId() throws Exception {
        GiveBack giveBack = new GiveBack();

        giveBack.setId(1L);
        LocalDateTime dataTime = LocalDateTime.of(2000, 10, 1, 2, 32);
        giveBack.setReturnDate(dataTime);

        Hire hire = new Hire();
        hire.setId(1L);
        DemandBookStatus demandBookStatus = DemandBookStatus.HIRED;
        hire.setStatus(demandBookStatus);

        LocalDateTime dataTime12 = LocalDateTime.of(2000, 10, 1, 2, 32);
        hire.setHireDate(dataTime12);

        Author author = new Author();
        author.setId((long)1);
        author.setName("Imie");
        author.setLastName("Nazwisko");

        Author author2 = new Author();
        author2.setId((long)1);
        author2.setName("Imie2");
        author2.setLastName("Nazwisko2");
        Set<Author> authorList = new HashSet<>();
        authorList.add(author);
        authorList.add(author2);

        PublishmentHouse publishmentHouse = new PublishmentHouse();
        publishmentHouse.setId((long)1);
        publishmentHouse.setName("Wydawnictwo");

        Category category = new Category();
        category.setId((long)1);
        category.setName("Kategoria");

        DemandBookStatus demandBookStatus12 = DemandBookStatus.IN_STOCK;

        Library library = new Library();
        library.setId((long)1);
        library.setCity("Miasto");
        library.setPostCode("30-300");
        library.setEmail("Email");
        library.setPhoneNumber("Email");
        library.setStreetAndNumber("ulica i numer 13");
        hire.setLibrary(library);

        Book book = new Book();
        book.setId((long)1);
        book.setTitle("Tytuł");
        book.setAuthor(authorList);
        book.setPublishmentYear("2000");
        book.setPublishmentHouse(publishmentHouse);
        book.setCategory(category);
        book.setDescription("dsadsaasdsajkdhawkjfgqweifbewigfbewrohvbaerwiouvhrbsdjpikughfpseao;finhbseiughbwaesgovarheupbsrvou");
        book.setImgUrl("URL/RUD/SDAD");
        book.setStatus(demandBookStatus12);
        book.setLibrary(library);
        hire.setBook(book);

        Role role = new Role();
        role.setName("ROLE_EMPLOYEE");

        User user = new User();
        user.setRole(role);
        user.setLastName("Imie");
        user.setFirstName("Nazwisko");
        user.setZip("39-120");
        user.setEmail("email@com.com");
        user.setPhoneNumber("321312321");
        user.setPESEL("321312312321");
        user.setCity("Rzeszow");
        user.setEnabled(true);

        hire.setUser(user);
        giveBack.setHire(hire);

        giveBack.setEmployee(user);

        List<GiveBack> giveBackList = new ArrayList<>();
        giveBackList.add(giveBack);

        Mockito.when(repository.getGiveBacksByUserId(user.getId())).thenReturn(giveBackList);
        String url = "/givebacks/user/1";

        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }
}
