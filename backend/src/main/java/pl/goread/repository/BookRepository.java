package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.goread.model.Book;
import pl.goread.model.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Find all books with the given title.
     *
     * @param title The title of the book to search for.
     * @return A list of books with the title specified.
     */
    List<Book> findBooksByTitle(String title);

    /**
     * Find all books whose title contains the given string.
     *
     * @param title The name of the method parameter.
     * @return A list of books that contain the input string in their title.
     */
    List<Book> findByTitleContains(@Param("input") String title);

    /**
     * Find all books that have the given category.
     *
     * @param category The category to search for.
     * @return A list of books that are in the category.
     */
    List<Book> findBooksByCategory(Category category);
}