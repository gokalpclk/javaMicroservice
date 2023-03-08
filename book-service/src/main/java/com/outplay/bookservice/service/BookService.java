package com.outplay.bookservice.service;

import com.outplay.bookservice.core.utilities.mappers.ModelMapperService;
import com.outplay.bookservice.dto.BookDto;
import com.outplay.bookservice.dto.BookIdDto;
import com.outplay.bookservice.exception.BookNotFoundException;
import com.outplay.bookservice.model.Book;
import com.outplay.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;

    public List<BookDto> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        List<BookDto> bookDtoList = bookList.stream().map(
                book -> this.modelMapperService.forResponse().map(book, BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    public BookIdDto findByIsbn(String isbn) {
        Book book = bookRepository.getBookByIsbn(isbn).orElseThrow(
                () -> new BookNotFoundException("Book could not found by isbn: " + isbn));

        return this.modelMapperService.forResponse().map(book, BookIdDto.class);
    }

    public BookDto findBookDetailsById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book could not found exception by id: " + id));
        return modelMapperService.forResponse().map(book, BookDto.class);
    }

}
