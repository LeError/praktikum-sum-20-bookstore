package com.sap.devcamp.bookstore.rest;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.services.IBookService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller @RequestMapping (path = BookController.PATH) public class BookController {

    private static final String PATH_PART_BOOK = "books";
    public static final String PATH = IRestController.REST_API_PATH + PATH_PART_BOOK;

    private final IBookService bookService;

    public BookController (IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping (path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks () {
        return null;
    }

    @GetMapping (path = "/author/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooksOfAuthor (@PathVariable (name = "author") String author) {
        return null;
    }

    @GetMapping (path = "/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook (@PathVariable ("isbn") String isbn) {
        return null;
    }

    @PutMapping (path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBook (@RequestBody Book book) {
        return null;
    }

    @PutMapping (path = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooks (@RequestBody List<Book> books) {
        return null;
    }

    @PostMapping (path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBook (@RequestBody Book book) {
        return null;
    }

    @DeleteMapping (path = "/book/{isbn}")
    public ResponseEntity removeBook (@PathVariable String isbn) {
        return null;
    }

}
