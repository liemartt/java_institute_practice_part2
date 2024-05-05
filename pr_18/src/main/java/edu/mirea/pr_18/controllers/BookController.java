package edu.mirea.pr_18.controllers;

import edu.mirea.pr_18.dto.BookDto;
import edu.mirea.pr_18.entities.Book;
import edu.mirea.pr_18.services.BookService;
import edu.mirea.pr_18.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final EmailService emailService;
    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        return bookService.getBooks();
    }
    @PostMapping("/book")
    @Async
    public void addBook(@RequestParam String name, @RequestParam String creationDate) {
        Book book = new Book(name, LocalDate.parse(creationDate));
        emailService.sendEmail("liemartt@yandex.ru", "test", "New book: "+ book.getName());
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
