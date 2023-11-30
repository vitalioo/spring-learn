package com.example.springlearn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @Size(min = 2, max = 100, message = "Author should be between 2 and 100 characters")
    @Column(name = "author")
    private String author;

    @Size(min = 2, max = 50, message = "Genre should be between 2 and 50 characters")
    @Column(name = "genre")
    private String genre;
}
