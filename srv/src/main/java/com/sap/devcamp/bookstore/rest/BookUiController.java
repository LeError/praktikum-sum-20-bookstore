package com.sap.devcamp.bookstore.rest;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.services.IBookService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(BookUiController.PATH)
public class BookUiController {

    private static final String PATH_PART_BOOK = "ui/books";
    public static final String PATH = IRestController.REST_API_PATH + PATH_PART_BOOK;

    private final IBookService bookService;

    public BookUiController (IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

}
