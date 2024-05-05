package edu.mirea.pr_18.services;

import edu.mirea.pr_18.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    void deleteAuthorByName(String name);
    List<Author> getAuthorsAsc(String fieldToSort);
    List<Author> getAuthorsDesc(String fieldToSort);
}
