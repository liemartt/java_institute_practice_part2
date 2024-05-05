package edu.mirea.pr_18.repositories;

import edu.mirea.pr_18.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByName(String authorName);
    void deleteByName(String name);
}
