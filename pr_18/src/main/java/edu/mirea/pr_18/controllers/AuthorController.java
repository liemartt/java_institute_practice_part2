package edu.mirea.pr_18.controllers;

import edu.mirea.pr_18.entities.Author;
import edu.mirea.pr_18.services.AuthorService;
import edu.mirea.pr_18.services.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorServiceImpl authorService;
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
    public void deleteAuthor(@RequestParam String name) {
        authorService.deleteAuthorByName(name);
    }

    @GetMapping("/authors/asc/{fieldToSort}")
    public List<Author> getAuthorsAsc(@PathVariable String fieldToSort) {
        return authorService.getAuthorsAsc(fieldToSort);
    }
    @GetMapping("/authors/desc/{fieldToSort}")
    public List<Author> getAuthorsDesc(@PathVariable String fieldToSort) {
        return authorService.getAuthorsDesc(fieldToSort);
    }
}
