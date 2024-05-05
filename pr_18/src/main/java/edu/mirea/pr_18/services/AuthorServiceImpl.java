package edu.mirea.pr_18.services;

import edu.mirea.pr_18.entities.Author;
import edu.mirea.pr_18.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public List<Author> getAuthors() {
        log.info("Get all authors");
        return authorRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteAuthorByName(String name) {
        log.info("Delete author by name: {}", name);
        authorRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public List<Author> getAuthorsAsc(String fieldToSort) {
        log.info("Get all authors asc by {}", fieldToSort);
        return authorRepository.findAll(Sort.by(Sort.Direction.ASC, fieldToSort));
    }

    @Override
    @Transactional
    public List<Author> getAuthorsDesc(String fieldToSort) {
        log.info("Get all authors desc by {}", fieldToSort);
        return authorRepository.findAll(Sort.by(Sort.Direction.DESC, fieldToSort));
    }

    @Transactional
    public void addAuthor(Author author) {
        log.info("Add author: {}", author);
        authorRepository.save(author);
    }
}
