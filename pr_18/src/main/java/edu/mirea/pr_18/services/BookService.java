package edu.mirea.pr_18.services;

import edu.mirea.pr_18.dto.BookDto;
import edu.mirea.pr_18.entities.Book;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks();
    void deleteBookByName(String name);
    void addNewBook(Book book);
    void addAuthorToBook(String bookName, String authorName);
    List<BookDto> getBooksAsc(String fieldToSort);
    List<BookDto> getBooksDesc(String fieldToSort);
}
