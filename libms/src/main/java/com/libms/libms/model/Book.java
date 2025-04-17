package com.libms.libms.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(unique = true, nullable = false)
    private String isbn;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Publisher publisher;

}
