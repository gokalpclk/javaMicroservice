package com.outplay.bookservice.repository;

import com.outplay.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> getBookByIsbn(String isbn);
}
