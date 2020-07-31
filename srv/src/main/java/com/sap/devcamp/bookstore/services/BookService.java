package com.sap.devcamp.bookstore.services;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service public class BookService
implements IBookService {

    private final IBookRepository bookRepository;

    public BookService (IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override public List<Book> getAllBooks () {
        return bookRepository.getAll();
    }

    @Override public Book getBook (final String isbn) {
        if (bookRepository.existsBookByIsbn(isbn)) {
            return bookRepository.findBookByIsbn(isbn);
        }
        throw new EntityNotFoundException("Could not find Book entity with ISBN: " + isbn);
    }

    @Override public List<Book> getBookByAuthor (final String author) {
        return bookRepository.findBooksByAuthorLike("%" + author + "%");
    }

    @Override public Book updateBook (final Book book) {
        if (bookRepository.existsBookByIsbn(book.getIsbn())) {
            bookRepository.save(book);
            return bookRepository.findBookByIsbn(book.getIsbn());
        }
        throw new EntityNotFoundException("Could not update Book entity because it does not exist. " + book.getIsbn());
    }

    @Override public void saveBook (final Book book) {
        if (!bookRepository.existsBookByIsbn(book.getIsbn())) {
            bookRepository.save(book);
        } else {
            throw new EntityExistsException("Could not save Book entity with ISBN " + book.getIsbn() + ". An entity with that ISBN already exists.");
        }
    }

    @Override public void saveAllBooks (List<Book> books) {
        for (Book book : books) {
            saveBook(book);
        }
    }

    @Override @Transactional public void removeBook (final String isbn) {
        if (bookRepository.existsBookByIsbn(isbn)) {
            bookRepository.deleteBookByIsbn(isbn);
        } else {
            throw new EntityNotFoundException("Could nor delete Book entity because it could not be found. ISBN: " + isbn);
        }
    }
}
