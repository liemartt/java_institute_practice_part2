package edu.mirea.pr_15;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(generator = "author_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "author_id_seq", sequenceName = "author_id_sequence", allocationSize = 1)
    private Long id;
    private String name;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    public Author(String name, String middleName, String lastName, LocalDate dateOfBirth) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
