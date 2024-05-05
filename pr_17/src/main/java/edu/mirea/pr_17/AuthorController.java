package edu.mirea.pr_17;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/authors/asc/{fieldToSort}")
    public List<Author> getAuthorsAsc(@PathVariable String fieldToSort) {
        return authorService.getAuthorsAsc(fieldToSort);
    }
    @GetMapping("/authors/desc/{fieldToSort}")
    public List<Author> getAuthorsDesc(@PathVariable String fieldToSort) {
        return authorService.getAuthorsDesc(fieldToSort);
    }
}
