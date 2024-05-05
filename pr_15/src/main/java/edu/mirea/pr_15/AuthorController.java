package edu.mirea.pr_15;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAuthors();
    }
    @PostMapping("/author")
    public void addAuthor(@RequestParam String name, @RequestParam String lastName, @RequestParam String middleName, @RequestParam String birthDate) {
        Author author = new Author(name, lastName, middleName, LocalDate.parse(birthDate));
        authorService.addAuthor(author);
    }
    @DeleteMapping("/author")
    public void deleteBook(@RequestParam String name) {
        authorService.deleteAuthorByName(name);
    }
}
