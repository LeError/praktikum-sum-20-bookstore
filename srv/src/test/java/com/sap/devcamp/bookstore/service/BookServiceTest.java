package com.sap.devcamp.bookstore.service;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.repositories.IBookRepository;
import com.sap.devcamp.bookstore.services.BookService;
import com.sap.devcamp.bookstore.services.IBookService;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private IBookRepository bookRepository;
    private IBookService cut;

    @Before public void setUp () {
        bookRepository = mock(IBookRepository.class);
        cut = new BookService(bookRepository);
    }

    @Test public void doCheck_getAllBooks_success () {
        List<Book> mockBooks = List.of(mock(Book.class), mock(Book.class));
        when(bookRepository.findAll()).thenReturn(mockBooks);
        cut.getAllBooks();
    }

    @Test public void doCheck_getBook_success () {
        Book mockBook = mock(Book.class);
        when(bookRepository.existsBookByIsbn(anyString())).thenReturn(true);
        when(bookRepository.findBookByIsbn(anyString())).thenReturn(mockBook);
        cut.getBook("test");
    }

    @Test (expected = EntityNotFoundException.class) public void doCheck_getBook_fail () {
        when(bookRepository.existsBookByIsbn(anyString())).thenReturn(false);
        cut.getBook("test");
    }

    @Test public void doCheck_getBookByAuthor_success () {
        List<Book> mockBooks = List.of(mock(Book.class), mock(Book.class));
        when(bookRepository.findBooksByAuthorLike(anyString())).thenReturn(mockBooks);
        cut.getBookByAuthor("test");
    }

    @Test public void doCheck_updateBook_success () {
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn("test");
        when(bookRepository.existsBookByIsbn(anyString())).thenReturn(true);
        when(bookRepository.findBookByIsbn(anyString())).thenReturn(mockBook);
        cut.updateBook(mockBook);
    }

    @Test (expected = EntityNotFoundException.class) public void doCheck_updateBook_fail () {
        Book mockBook = mock(Book.class);
        when(bookRepository.existsBookByIsbn(anyString())).thenReturn(false);
        cut.updateBook(mockBook);
    }

    @Test public void doCheck_saveBook_success () {
        Book mockBook = mock(Book.class);
        when(bookRepository.existsBookByIsbn(any())).thenReturn(false);
        cut.saveBook(mockBook);
    }

    @Test (expected = EntityExistsException.class) public void doCheck_saveBook_fail () {
        Book mockBook = mock(Book.class);
        when(bookRepository.existsBookByIsbn(any())).thenReturn(true);
        cut.saveBook(mockBook);
    }

    @Test public void doCheck_saveAllBooks_success () {
        List<Book> mockBooks = List.of(mock(Book.class), mock(Book.class));
        when(bookRepository.existsBookByIsbn(any())).thenReturn(false);
        cut.saveAllBooks(mockBooks);
    }

    @Test (expected = EntityExistsException.class) public void doCheck_saveAllBooks_fail () {
        List<Book> mockBooks = List.of(mock(Book.class), mock(Book.class));
        when(bookRepository.existsBookByIsbn(any())).thenReturn(true);
        cut.saveAllBooks(mockBooks);
    }

    @Test public void doCheck_removeBook_success () {
        when(bookRepository.existsBookByIsbn(any())).thenReturn(true);
        cut.removeBook("test");
    }

    @Test (expected = EntityNotFoundException.class) public void doCheck_removeBook_fail () {
        when(bookRepository.existsBookByIsbn(any())).thenReturn(false);
        cut.removeBook("test");
    }

}
