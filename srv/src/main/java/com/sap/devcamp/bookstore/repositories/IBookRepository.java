package com.sap.devcamp.bookstore.repositories;

import com.sap.devcamp.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface IBookRepository
extends JpaRepository<Book, String> {

}
