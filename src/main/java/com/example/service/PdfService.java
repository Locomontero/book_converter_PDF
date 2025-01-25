package com.example.service;

import com.example.model.Book;
import com.example.model.Chapter;
import com.example.model.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class PdfService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void convertJsonToPdf() throws IOException, DocumentException {
        File jsonFile = new File("src/main/resources/Books.json");

        if (!jsonFile.exists()) {
            throw new FileNotFoundException("Arquivo Books.json não encontrado no caminho: " + jsonFile.getAbsolutePath());
        }

        List<Book> books = objectMapper.readValue(jsonFile, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("Books.pdf"));
        document.open();

        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        Font chapterFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.ITALIC);

        for (Book book : books) {
            Paragraph bookTitle = new Paragraph("Book Title: " + book.getTitle(), titleFont);
            bookTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(bookTitle);

            Paragraph bookAuthor = new Paragraph("Author: " + book.getAuthor(), normalFont);
            document.add(bookAuthor);

            Paragraph bookYear = new Paragraph("Published Year: " + book.getPublishedYear(), normalFont);
            document.add(bookYear);

            Paragraph bookGenre = new Paragraph("Genre: " + book.getGenre(), normalFont);
            document.add(bookGenre);

            document.add(new Paragraph(" "));

            for (Chapter chapter : book.getChapters()) {
                Paragraph chapterTitle = new Paragraph("Chapter: " + chapter.getTitle(), chapterFont);
                document.add(chapterTitle);

                Paragraph chapterNumber = new Paragraph("Chapter Number: " + chapter.getChapterNumber(), normalFont);
                document.add(chapterNumber);

                for (Page page : chapter.getPages()) {
                    Paragraph pageContent = new Paragraph("Page " + page.getPageNumber() + ": " + page.getContent(), normalFont);
                    document.add(pageContent);
                }

                document.add(new Paragraph(" "));
            }

            document.add(new Paragraph("____________________________________________________________________"));
        }

        document.close();
    }
}
