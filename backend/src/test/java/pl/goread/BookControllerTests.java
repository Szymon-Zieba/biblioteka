package pl.goread;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.goread.controller.BookController;
import pl.goread.model.*;
import pl.goread.model.enums.DemandBookStatus;
import pl.goread.repository.BookRepository;
import pl.goread.service.BookService;
import pl.goread.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService service;

    @MockBean
    private BookRepository repository;

    @MockBean
    private UserService userService;

    @Test
    public void getBooks() throws Exception {
        Book book = new Book();
        Book book2 = new Book();

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

        DemandBookStatus demandBookStatus = DemandBookStatus.IN_STOCK;

        Library library = new Library();
        library.setId((long)1);
        library.setCity("Miasto");
        library.setPostCode("30-300");
        library.setEmail("Email");
        library.setPhoneNumber("Email");
        library.setStreetAndNumber("ulica i numer 13");

        book.setId((long)1);
        book.setTitle("Tytuł");
        book.setAuthor(authorList);
        book.setPublishmentYear("2000");
        book.setPublishmentHouse(publishmentHouse);
        book.setCategory(category);
        book.setDescription("dsadsaasdsajkdhawkjfgqweifbewigfbewrohvbaerwiouvhrbsdjpikughfpseao;finhbseiughbwaesgovarheupbsrvou");
        book.setImgUrl("URL/RUD/SDAD");
        book.setStatus(demandBookStatus);
        book.setLibrary(library);

        book2.setId((long)2);
        book2.setTitle("Tytu2ł");
        book2.setAuthor(authorList);
        book2.setPublishmentYear("2002");
        book2.setPublishmentHouse(publishmentHouse);
        book2.setCategory(category);
        book2.setDescription("dsadsaasdsajkdhawkjfgqweifbewigfbewrohvbaerwiouvhrbsdjpikughfpseao;finhbseiughbwaesgovarheupbsrvou");
        book2.setImgUrl("URL/RUD/SDAD2");
        book2.setStatus(demandBookStatus);
        book2.setLibrary(library);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book2);
        Mockito.when(repository.findAll()).thenReturn(bookList);
        String url = "/books";

        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getBookById() throws Exception {
        Book book = new Book();

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

        DemandBookStatus demandBookStatus = DemandBookStatus.IN_STOCK;

        Library library = new Library();
        library.setId((long)1);
        library.setCity("Miasto");
        library.setPostCode("30-300");
        library.setEmail("Email");
        library.setPhoneNumber("Email");
        library.setStreetAndNumber("ulica i numer 13");

        book.setId((long)1);
        book.setTitle("Tytuł");
        book.setAuthor(authorList);
        book.setPublishmentYear("2000");
        book.setPublishmentHouse(publishmentHouse);
        book.setCategory(category);
        book.setDescription("dsadsaasdsajkdhawkjfgqweifbewigfbewrohvbaerwiouvhrbsdjpikughfpseao;finhbseiughbwaesgovarheupbsrvou");
        book.setImgUrl("URL/RUD/SDAD");
        book.setStatus(demandBookStatus);
        book.setLibrary(library);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        Mockito.when(service.getBookById(book.getId())).thenReturn(book);
        String url = "/book/1";

        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }
}
