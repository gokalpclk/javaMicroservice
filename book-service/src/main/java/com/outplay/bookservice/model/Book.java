package com.outplay.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    public Book(String title, int bookYear, String author, String pressName, String isbn) {
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
        this.isbn = isbn;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String title;

    private int bookYear;
    private String author;
    private String pressName;
    private String isbn;


}
