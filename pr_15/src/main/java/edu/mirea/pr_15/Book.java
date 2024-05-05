package edu.mirea.pr_15;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "book_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private LocalDate creationDate;

    public Book(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
}
