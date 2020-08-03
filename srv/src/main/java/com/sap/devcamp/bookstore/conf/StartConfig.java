package com.sap.devcamp.bookstore.conf;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class StartConfig implements CommandLineRunner {

    public final BookService bookService;

    public StartConfig(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        bookService.saveBook(new Book("32424242-324234-3242342-342", "Der Mann und das Meer", "Hans Müller", new Date(), null, 100, 12.5f));
        bookService.saveBook(new Book("45645654-567567-0980989-342", "Shark", "Heidegunst Matkins", new Date(), null, 56, 62.5f));
        bookService.saveBook(new Book("32424242-324234-9808909-342", "The Mummy", "Jürgen Müller", new Date(), null, 12, 9.5f));
        bookService.saveBook(new Book("32424242-324234-5465466-234", "IT", "Steven King", new Date(), null, 30, 14.5f));
        bookService.saveBook(new Book("87987898-876787-3242342-342", "Schattenstunde", "Dietmar Gamsbach", new Date(), null, 78, 18.5f));
    }
}
