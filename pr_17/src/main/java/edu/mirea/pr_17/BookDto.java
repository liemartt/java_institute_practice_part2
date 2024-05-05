package edu.mirea.pr_17;

import java.time.LocalDate;

public record BookDto(Long id, String name, LocalDate creationDate, Author author) {
}
