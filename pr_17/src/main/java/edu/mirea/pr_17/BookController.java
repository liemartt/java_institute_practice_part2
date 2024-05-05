package edu.mirea.pr_17;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
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
    @PostMapping("/book/new-author")
    public void addAuthorToBook(@RequestParam String bookName, @RequestParam String authorName) {
        bookService.addAuthorToBook(bookName, authorName);
    }
    @GetMapping("/books/asc/{fieldToSort}")
    public List<BookDto> getBooksAsc(@PathVariable String fieldToSort) {
        return bookService.getBooksAsc(fieldToSort);
    }
    @GetMapping("/books/desc/{fieldToSort}")
    public List<BookDto> getBooksDesc(@PathVariable String fieldToSort) {
        return bookService.getBooksDesc(fieldToSort);
    }
}
