package com.sap.devcamp.bookstore.rest;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.services.IBookService;
import org.springframework.http.HttpStatus;
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

    @GetMapping (path = "/all", produces = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<List<Book>> getAllBooks () {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping (path = "/author/{author}", produces = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<List<Book>> getAllBooksOfAuthor (@PathVariable (name = "author") String author) {
        return new ResponseEntity<>(bookService.getBookByAuthor(author), HttpStatus.OK);
    }

    @GetMapping (path = "/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Book> getBook (@PathVariable ("isbn") String isbn) {
        return new ResponseEntity<>(bookService.getBook(isbn), HttpStatus.OK);
    }

    @PutMapping (path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity saveBook (@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping (path = "/books", consumes = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity saveBooks (@RequestBody List<Book> books) {
        bookService.saveAllBooks(books);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping (path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity updateBook (@RequestBody Book book) {
        return new ResponseEntity(bookService.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping (path = "/book/{isbn}") public ResponseEntity removeBook (@PathVariable String isbn) {
        bookService.removeBook(isbn);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
