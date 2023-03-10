package com.outplay.libraryservice.client;

import com.outplay.libraryservice.dto.BookDto;
import com.outplay.libraryservice.dto.BookIdDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author Gokalp on 8.03.2023
 * @project javaMicroservice
 */

@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {
    Logger logger = LoggerFactory.getLogger(BookServiceClient.class);

    @GetMapping
     ResponseEntity<List<BookDto>> getAllBooks();

    @GetMapping("/isbn/{isbn}")
    @CircuitBreaker(name = "getBookByIsbnCircuitBreaker", fallbackMethod = "getBookFallBack")
     ResponseEntity<BookIdDto> getBookIdIsbn(@PathVariable String  isbn);

    default ResponseEntity<BookIdDto> getBookFallBack(String isbn, Exception exception){
        logger.info("Book not found by isbn: " + isbn+ ", returning default book object");
        return ResponseEntity.ok(new BookIdDto("default-book", "default-isbn"));
    }

    @GetMapping("/book/{bookId}")
    @CircuitBreaker(name = "getBookByIdCircuitBreaker", fallbackMethod = "getBookByIdFallBack")
     ResponseEntity<BookDto> getBookById(@PathVariable String bookId);

    default ResponseEntity<BookDto> getBookByIdFallBack(String bookId, Exception exception){
        logger.info("Book not found by id: " + bookId+ ", returning default BookDto");
        return ResponseEntity.ok(new BookDto(new BookIdDto("default-book", "default-isbn")));
    }
}
