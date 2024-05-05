package edu.mirea.pr_16;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAuthors();
    }
    @PostMapping("/author")
    public void addAuthor(@RequestParam String name) {
        Author author = new Author(name);
        authorService.addAuthor(author);
    }
    @DeleteMapping("/author")
    public void deleteBook(@RequestParam String name) {
        authorService.deleteAuthorByName(name);
    }
}
