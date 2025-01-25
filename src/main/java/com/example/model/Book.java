package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "published_year")
    private Integer publishedYear;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Chapter> chapters;
}
