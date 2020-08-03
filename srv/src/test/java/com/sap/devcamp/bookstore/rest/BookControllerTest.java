package com.sap.devcamp.bookstore.rest;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.services.BookService;
import com.sap.devcamp.bookstore.services.IBookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    private BookController cut;
    private IBookService bookService;

    private Book book1, book2, book3;
    private List<Book> books;

    @Before public void setUp () {
        bookService = mock(BookService.class);
        cut = new BookController(bookService);
        book1 = new Book();
        book1.setIsbn(UUID.randomUUID().toString());
        book2 = new Book();
        book2.setIsbn(UUID.randomUUID().toString());
        book3 = new Book();
        book3.setIsbn(UUID.randomUUID().toString());
        books = Arrays.asList(book1, book2, book3);
    }

    @Test public void doCheck_getAllBooks_expectEmptyList () {
        when(bookService.getAllBooks()).thenReturn(new ArrayList<>());
        final ResponseEntity<?> result = cut.getAllBooks();
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.OK, result.getStatusCode());
        assertEquals("Unexpected body returned", new ArrayList<>(), result.getBody());
    }

    @Test public void doCheck_getAllBooks_success () {
        when(bookService.getAllBooks()).thenReturn(books);
        final ResponseEntity<?> result = cut.getAllBooks();
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.OK, result.getStatusCode());
        assertEquals("Unexpected body returned", books, result.getBody());
    }

    @Test public void doCheck_getAllBooksOfAuthor_emptyList () {
        when(bookService.getBookByAuthor(any())).thenReturn(new ArrayList<>());
        final ResponseEntity<?> result = cut.getAllBooksOfAuthor("test");
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.OK, result.getStatusCode());
        assertEquals("Unexpected body returned", new ArrayList<>(), result.getBody());
    }

    @Test public void doCheck_getAllBooksOfAuthor_success () {
        when(bookService.getBookByAuthor(any())).thenReturn(books);
        final ResponseEntity<?> result = cut.getAllBooksOfAuthor("test");
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.OK, result.getStatusCode());
        assertEquals("Unexpected body returned", books, result.getBody());
    }

    @Test public void doCheck_getBook_success () {
        when(bookService.getBook(any())).thenReturn(book1);
        final ResponseEntity<?> result = cut.getBook("test");
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.OK, result.getStatusCode());
        assertEquals("Unexpected body returned", book1, result.getBody());
    }

    @Test public void doCheck_saveBook_success () {
        final ResponseEntity<?> result = cut.saveBook(book1);
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.NO_CONTENT, result.getStatusCode());
        assertNull("Unexpected body returned", result.getBody());
    }

    @Test public void doCheck_saveBooks_success () {
        final ResponseEntity<?> result = cut.saveBooks(books);
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.NO_CONTENT, result.getStatusCode());
        assertNull("Unexpected body returned", result.getBody());
    }

    @Test public void doCheck_updateBook_success () {
        when(bookService.updateBook(any())).thenReturn(book1);
        final ResponseEntity<?> result = cut.updateBook(book1);
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.OK, result.getStatusCode());
        assertEquals("Unexpected body returned", book1, result.getBody());
    }

    @Test public void doCheck_removeBook_success () {
        final ResponseEntity<?> result = cut.removeBook("test");
        assertNotNull("Missing response", result);
        assertEquals("Unexpected status returned", HttpStatus.NO_CONTENT, result.getStatusCode());
        assertNull("Unexpected body returned", result.getBody());
    }

}
