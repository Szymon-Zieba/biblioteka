package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Book;
import pl.goread.model.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByCategory(Category category);

}