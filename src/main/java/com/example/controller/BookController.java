package com.example.controller;

import com.example.service.BookService;
import com.example.service.PdfService;
import com.itextpdf.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/export-books")
    public String exportBooks() {
        try {
            bookService.exportBooksToJson();
            return "boooks.json com SUCCESS!";
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/convert-books-to-pdf")
    public String convertBooksToPdf() {
        try {
            pdfService.convertJsonToPdf();
            return "Livros convertidos para PDF com sucesso!";
        } catch (IOException | DocumentException e) {
            return "Erro ao converter livros para PDF: " + e.getMessage();
        }
    }
}
