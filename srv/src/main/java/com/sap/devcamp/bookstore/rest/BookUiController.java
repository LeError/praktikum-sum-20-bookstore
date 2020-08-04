package com.sap.devcamp.bookstore.rest;

import com.sap.devcamp.bookstore.services.IBookService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(BookUiController.PATH)
public class BookUiController {

    private static final String PATH_PART_BOOK = "ui/books";
    public static final String PATH = IRestController.REST_API_PATH + PATH_PART_BOOK;

    private final IBookService bookService;

    public BookUiController (IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping (path = "/all", produces = MediaType.APPLICATION_JSON_VALUE) public String getAllBooks (Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping (path = "/author/{author}", produces = MediaType.APPLICATION_JSON_VALUE) public String getAllBooksOfAuthor (@PathVariable (name = "author") String author, Model model) {
        model.addAttribute("books", bookService.getBookByAuthor(author));
        return "books";
    }

    @GetMapping (path = "/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE) public String getBook (@PathVariable ("isbn") String isbn, Model model) {
        model.addAttribute("books", bookService.getBook(isbn));
        return "books";
    }

}
