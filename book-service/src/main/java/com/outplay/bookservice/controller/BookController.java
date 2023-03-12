package com.outplay.bookservice.controller;

import com.outplay.bookservice.dto.BookDto;
import com.outplay.bookservice.dto.BookIdDto;
import com.outplay.bookservice.model.Book;
import com.outplay.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
@Validated
public class BookController {
    private final BookService bookService;
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookIdIsbn(@PathVariable @NotEmpty String  isbn){
        logger.info("Book requested by isbn: " + isbn);
        return ResponseEntity.ok(bookService.findByIsbn(isbn));

    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }
}
