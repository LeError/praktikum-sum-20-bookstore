package com.sap.devcamp.bookstore.repositories;

import com.sap.devcamp.bookstore.model.Book;
import com.sap.devcamp.bookstore.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class IBookRepositoryTest {

    @Autowired private IBookRepository cut;

    @Before public void setUp () {
        cut = new IBookRepository() {
            @Override public List<Book> getAll () {
                return null;
            }

            @Override public List<Book> findBooksByAuthorLike (String author) {
                return null;
            }

            @Override public Book findBookByIsbn (String isbn) {
                return null;
            }

            @Override public void deleteBookByIsbn (String isbn) {

            }

            @Override public boolean existsBookByIsbn (String isbn) {
                return false;
            }

            @Override public List<Book> findAll () {
                return null;
            }

            @Override public List<Book> findAll (Sort sort) {
                return null;
            }

            @Override public List<Book> findAllById (Iterable<String> iterable) {
                return null;
            }

            @Override public <S extends Book> List<S> saveAll (Iterable<S> iterable) {
                return null;
            }

            @Override public void flush () {

            }

            @Override public <S extends Book> S saveAndFlush (S s) {
                return null;
            }

            @Override public void deleteInBatch (Iterable<Book> iterable) {

            }

            @Override public void deleteAllInBatch () {

            }

            @Override public Book getOne (String s) {
                return null;
            }

            @Override public <S extends Book> List<S> findAll (Example<S> example) {
                return null;
            }

            @Override public <S extends Book> List<S> findAll (Example<S> example, Sort sort) {
                return null;
            }

            @Override public Page<Book> findAll (Pageable pageable) {
                return null;
            }

            @Override public <S extends Book> S save (S s) {
                return null;
            }

            @Override public Optional<Book> findById (String s) {
                return Optional.empty();
            }

            @Override public boolean existsById (String s) {
                return false;
            }

            @Override public long count () {
                return 0;
            }

            @Override public void deleteById (String s) {

            }

            @Override public void delete (Book book) {

            }

            @Override public void deleteAll (Iterable<? extends Book> iterable) {

            }

            @Override public void deleteAll () {

            }

            @Override public <S extends Book> Optional<S> findOne (Example<S> example) {
                return Optional.empty();
            }

            @Override public <S extends Book> Page<S> findAll (Example<S> example, Pageable pageable) {
                return null;
            }

            @Override public <S extends Book> long count (Example<S> example) {
                return 0;
            }

            @Override public <S extends Book> boolean exists (Example<S> example) {
                return false;
            }
        };
    }

    @Test public void doCheck_IBookRepository_isInterface () {
        TestUtils.doCheckIsInterface(IBookRepository.class);
    }

    @Test public void doCheck_IBookRepository_extendsJpaRepository () {
        TestUtils.doCheckIsJpaRepository(cut);
    }

}
