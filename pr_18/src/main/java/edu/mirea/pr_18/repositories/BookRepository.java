package edu.mirea.pr_18.repositories;

import edu.mirea.pr_18.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteBookByName(String bookName);
    Book findBookByName(String bookName);
}
