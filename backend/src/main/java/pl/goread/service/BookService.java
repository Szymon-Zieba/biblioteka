package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Book;
import pl.goread.model.Category;
import pl.goread.repository.BookRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> getBooksByCategory(Category category){
        return bookRepository.findBooksByCategory(category);
    }

}
