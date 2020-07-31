package com.sap.devcamp.bookstore.repositories;

import com.sap.devcamp.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository public interface IBookRepository
extends JpaRepository<Book, String> {

    @Query ("SELECT b FROM BOOK b ORDER BY b.title ASC") List<Book> getAll ();

    @Query ("SELECT b FROM BOOK b WHERE b.author LIKE :AUTHOR") List<Book> findBooksByAuthorLike (@Param ("AUTHOR") String author);

    Book findBookByIsbn (@Param ("ISBN") String isbn);

    void deleteBookByIsbn (@Param ("ISBN") String isbn);

    boolean existsBookByIsbn (@Param ("ISBN") String isbn);
}
