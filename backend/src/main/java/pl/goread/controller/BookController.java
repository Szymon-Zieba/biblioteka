package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.goread.repository.BookRepository;
import pl.goread.service.BookService;
import pl.goread.model.Book;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@CrossOrigin
public class BookController {

    private final BookRepository bookRepository;

    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks (@RequestParam("input") Optional<String> input) throws UnsupportedEncodingException {
        if (input.isPresent()) {
            String decodedInput = URLDecoder.decode(input.get(), StandardCharsets.UTF_8.toString());
            return bookService.getBooksBySearch(decodedInput);
        }
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public Book postBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.delete(bookService.getBookById(id));
    }

}

