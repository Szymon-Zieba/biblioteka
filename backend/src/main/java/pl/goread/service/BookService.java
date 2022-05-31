package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.goread.model.Author;
import pl.goread.model.Book;
import pl.goread.model.Category;
import pl.goread.model.enums.DemandBookStatus;
import pl.goread.repository.AuthorRepository;
import pl.goread.repository.BookRepository;
import pl.goread.repository.CategoryRepository;
import pl.goread.repository.PublishmentHouseRepository;

import javax.persistence.EntityNotFoundException;
import java.util.*;


@Service
@RequiredArgsConstructor
public class BookService {

    private static final String BOOK_NOT_FOUND_MSG = "Nie znaleziono takiej książki";
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final PublishmentHouseRepository publishmentHouseRepository;
    private final CategoryRepository categoryRepository;

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> getBooksByCategory(Category category){
        return bookRepository.findBooksByCategory(category);
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(BOOK_NOT_FOUND_MSG));
    }

    public List<Book> getBooksBySearch(String input){
        return bookRepository.findByTitleContains(input);
    }

    public void updateBook(Long id, String status){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(BOOK_NOT_FOUND_MSG));
        System.out.println(bookRepository.findById(id));
        book.setStatus(DemandBookStatus.valueOf(status));
        System.out.println(book.getStatus());

        bookRepository.save(book);
    }

    public Book addBook(Book book){
        ArrayList<Author> authorList = new ArrayList<>();
        for(int i = 0; i < book.getAuthor().size(); i++) {
            Author a = new ArrayList<Author>(book.getAuthor()).get(i);
            boolean booleanAuthorByNameAndLastName =  authorRepository.existsAuthorByNameAndLastName(a.getName(), a.getLastName());
            if (!booleanAuthorByNameAndLastName) {
                authorRepository.save(a);
            }
            authorList.add(i, authorRepository.findByNameAndLastName(a.getName(), a.getLastName()));
        }
        book.setAuthor(new HashSet<>(authorList));

        if(!publishmentHouseRepository.existsPublishmentHouseByName(book.getPublishmentHouse().getName())){
            publishmentHouseRepository.save(book.getPublishmentHouse());
        }
        book.setPublishmentHouse(publishmentHouseRepository.findByName(book.getPublishmentHouse().getName()));


        if(!categoryRepository.existsCategoryByName(book.getCategory().getName())){
            System.out.println(categoryRepository.existsCategoryByName(book.getCategory().getName()));
            categoryRepository.save(book.getCategory());
        }
        book.setCategory(categoryRepository.findByName(book.getCategory().getName()));

        return bookRepository.save(book);
    }
}
