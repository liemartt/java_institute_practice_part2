package edu.mirea.pr_18.services;

import edu.mirea.pr_18.dto.BookDto;
import edu.mirea.pr_18.entities.Author;
import edu.mirea.pr_18.entities.Book;
import edu.mirea.pr_18.repositories.AuthorRepository;
import edu.mirea.pr_18.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Override
    @Transactional
    public List<BookDto> getBooks() {
        log.info("Get all books");
        return bookRepository.findAll().stream().map(x->new BookDto(x.getId(), x.getName(), x.getCreationDate(), x.getAuthor())).toList();
    }

    @Override
    @Transactional
    public void deleteBookByName(String name) {
        log.info("Delete book by name: {}", name);
        bookRepository.deleteBookByName(name);
    }

    @Override
    @Transactional
    public void addNewBook(Book book) {
        log.info("Add new book: {}", book);
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void addAuthorToBook(String bookName, String authorName) {
        log.info("Add author to {}, author: {}", bookName, authorName);
        Book book = bookRepository.findBookByName(bookName);
        Author author = authorRepository.findAuthorByName(authorName);
        book.setAuthor(author);
    }

    @Override
    @Transactional
    public List<BookDto> getBooksAsc(String fieldToSort) {
        log.info("Get all books asc by {}", fieldToSort);
        return bookRepository.findAll(Sort.by(fieldToSort).ascending()).stream().map(x->new BookDto(x.getId(), x.getName(), x.getCreationDate(), x.getAuthor())).toList();
    }

    @Override
    @Transactional
    public List<BookDto> getBooksDesc(String fieldToSort) {
        log.info("Get all books desc by {}", fieldToSort);
        return bookRepository.findAll(Sort.by(fieldToSort).descending()).stream().map(x->new BookDto(x.getId(), x.getName(), x.getCreationDate(), x.getAuthor())).toList();
    }
}
