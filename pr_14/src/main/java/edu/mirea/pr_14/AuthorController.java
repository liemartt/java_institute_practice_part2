package edu.mirea.pr_14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AuthorController {
    private final List<Author> authors = new ArrayList<Author>();
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authors;
    }
    @PostMapping("/author")
    public Author addAuthor(@RequestParam String name, @RequestParam String lastName, @RequestParam String middleName, @RequestParam Date birthDate) {
        Author author = new Author(name, lastName, middleName, birthDate);
        authors.add(author);
        return author;
    }
    @DeleteMapping("/author")
    public void deleteBook(@RequestParam String name) {
        authors.removeIf(x->x.name().equals(name));
    }
}
