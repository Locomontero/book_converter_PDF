package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional(readOnly = true)
    public void exportBooksToJson() throws IOException {
        List<Book> books = bookRepository.findAll();

        File file = new File("src/main/resources/Books.json");

        objectMapper.writeValue(file, books);
    }
}

