package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Integer chapterId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;

    @Column(name = "title")
    private String title;

    @Column(name = "chapter_number")
    private Integer chapterNumber;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Page> pages;
}
