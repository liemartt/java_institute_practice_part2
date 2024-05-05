package edu.mirea.pr_16;

import java.time.LocalDate;

public record BookDto(Long id, String name, LocalDate creationDate, Author author) {
}
