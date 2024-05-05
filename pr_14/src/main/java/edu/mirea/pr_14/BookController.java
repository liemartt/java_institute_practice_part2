package edu.mirea.pr_14;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final List<Book> books = new ArrayList<Book>();
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }
    @PostMapping("/book")
    public Book addBook(@RequestParam String name, @RequestParam String creationDate) {
        Book book = new Book(name, LocalDate.parse(creationDate));
        books.add(book);
        return book;
    }
    @DeleteMapping("/book")
    public void deleteBook(@RequestParam String name) {
        books.removeIf(x->x.name().equals(name));
    }
}
