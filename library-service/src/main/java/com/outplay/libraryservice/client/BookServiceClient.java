package com.outplay.libraryservice.client;

import com.outplay.libraryservice.dto.BookDto;
import com.outplay.libraryservice.dto.BookIdDto;
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

    @GetMapping
     ResponseEntity<List<BookDto>> getAllBooks();

    @GetMapping("/isbn/{isbn}")
     ResponseEntity<BookIdDto> getBookIdIsbn(@PathVariable String  isbn);

    @GetMapping("/book/{bookId}")
     ResponseEntity<BookDto> getBookById(@PathVariable String bookId);
}
