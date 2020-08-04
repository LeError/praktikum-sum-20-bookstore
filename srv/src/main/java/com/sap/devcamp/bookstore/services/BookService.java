package com.sap.devcamp.bookstore.services;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class BookService
implements IBookService {

    private final IBookRepository bookRepository;

    public BookService (IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override public List<Book> getAllBooks () {
        return null;
    }

    @Override public Book getBook (String isbn) {
        return null;
    }

    @Override public List<Book> getBookByAuthor (String author) {
        return null;
    }

    @Override public Book updateBook (Book book) {
        return null;
    }

    @Override public void saveBook (Book book) {

    }

    @Override public void saveAllBooks (List<Book> books) {

    }

    @Override public void removeBook (String isbn) {

    }
}
