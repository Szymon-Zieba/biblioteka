package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Author;
import pl.goread.model.Book;
import pl.goread.model.Category;
import pl.goread.model.enums.DemandBookStatus;
import pl.goread.repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private static final String BOOK_NOT_FOUND_MSG = "Nie znaleziono takiej książki";
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final PublishmentHouseRepository publishmentHouseRepository;
    private final CategoryRepository categoryRepository;

    private final LibraryRepository libraryRepository;

    /**
     * Return a list of books whose title matches the given title.
     *
     * @param title The title of the book you want to search for.
     * @return A list of books with the title specified.
     */
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    /**
     * Get all books that have a category that matches the category passed in.
     *
     * @param category The category of the books you want to retrieve.
     * @return A list of books that are in the category.
     */
    public List<Book> getBooksByCategory(Category category) {
        return bookRepository.findBooksByCategory(category);
    }

    /**
     * If the book exists, return it, otherwise throw an exception.
     *
     * @param id The id of the book to be retrieved.
     * @return A book object
     */
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(BOOK_NOT_FOUND_MSG));
    }

    /**
     * Find all books whose title contains the input string.
     *
     * @param input The search term that the user enters.
     * @return A list of books that contain the input string in the title.
     */
    public List<Book> getBooksBySearch(String input) {
        return bookRepository.findByTitleContains(input);
    }

    /**
     * It takes in a book id and a status, finds the book with the given id, sets the status of the book to the given
     * status, and saves the book
     *
     * @param id     the id of the book to be updated
     * @param status status of the book
     */
    public void updateBook(Long id, String status) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(BOOK_NOT_FOUND_MSG));
        System.out.println(bookRepository.findById(id));
        book.setStatus(DemandBookStatus.valueOf(status));
        System.out.println(book.getStatus());

        bookRepository.save(book);
    }

    /**
     * The function adds a book to the database
     *
     * @param book the book object that is passed to the method.
     * @return Book
     */
    public Book addBook(Book book) {
        ArrayList<Author> authorList = new ArrayList<>();
        for (int i = 0; i < book.getAuthor().size(); i++) {
            Author a = new ArrayList<Author>(book.getAuthor()).get(i);
            boolean booleanAuthorByNameAndLastName = authorRepository.existsAuthorByNameAndLastName(a.getName(), a.getLastName());
            if (!booleanAuthorByNameAndLastName) {
                authorRepository.save(a);
            }
            authorList.add(i, authorRepository.findByNameAndLastName(a.getName(), a.getLastName()));
        }
        book.setAuthor(new HashSet<>(authorList));

        if (!publishmentHouseRepository.existsPublishmentHouseByName(book.getPublishmentHouse().getName())) {
            publishmentHouseRepository.save(book.getPublishmentHouse());
        }
        book.setPublishmentHouse(publishmentHouseRepository.findByName(book.getPublishmentHouse().getName()));


        if (!categoryRepository.existsCategoryByName(book.getCategory().getName())) {
            System.out.println(categoryRepository.existsCategoryByName(book.getCategory().getName()));
            categoryRepository.save(book.getCategory());
        }
        book.setCategory(categoryRepository.findByName(book.getCategory().getName()));

        book.setLibrary(libraryRepository.findById(book.getLibrary().getId()).orElseThrow());

        return bookRepository.save(book);
    }
}
