package com.sap.devcamp.bookstore.services;

import com.sap.devcamp.bookstore.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks ();

    Book getBook (String isbn);

    List<Book> getBookByAuthor (String author);

    Book updateBook (Book book);

    void saveBook (Book book);

    void saveAllBooks (List<Book> books);

    void removeBook (String isbn);

}
