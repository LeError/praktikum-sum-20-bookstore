package com.sap.devcamp.bookstore.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data @ToString @NoArgsConstructor @EqualsAndHashCode @Entity (name = "BOOK") @JsonNaming (PropertyNamingStrategy.UpperCamelCaseStrategy.class) public class Book {

    @Id @Column (name = "ISBN") private String isbn;

    @Column (name = "TITLE", nullable = false) private String title;

    @Column (name = "AUTHOR", nullable = false) private String author;

    @Column (name = "YEAR") private Date year;

    @Column (name = "EDITOR") private String editor;

    @Column (name = "STOCK") private int stock = 0;

    @Column (name = "PRICE") private float price = 0.0f;

}
