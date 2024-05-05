package edu.mirea.pr_15;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }
    @PostMapping("/book")
    public void addBook(@RequestParam String name, @RequestParam String creationDate) {
        Book book = new Book(name, LocalDate.parse(creationDate));
        bookService.addNewBook(book);
    }
    @DeleteMapping("/book")
    public void deleteBook(@RequestParam String name) {
        bookService.deleteBookByName(name);
    }
}
