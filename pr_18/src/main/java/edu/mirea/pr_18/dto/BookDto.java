package edu.mirea.pr_18.dto;

import edu.mirea.pr_18.entities.Author;

import java.time.LocalDate;

public record BookDto(Long id, String name, LocalDate creationDate, Author author) {
}
