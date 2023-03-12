package com.outplay.libraryservice.service;

import com.outplay.libraryservice.client.BookServiceClient;
import com.outplay.libraryservice.core.utilities.mappers.ModelMapperService;
import com.outplay.libraryservice.dto.AddBookRequest;
import com.outplay.libraryservice.dto.LibraryDto;
import com.outplay.libraryservice.exception.LibraryNotFoundException;
import com.outplay.libraryservice.model.Library;
import com.outplay.libraryservice.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final ModelMapperService modelMapperService;
    private final BookServiceClient bookServiceClient;


    public LibraryDto getAllBooksInLibraryById(String id) {
        Library library = libraryRepository.findById(id).orElseThrow(
                () -> new LibraryNotFoundException("Library could not found: " + id));
        LibraryDto libraryDto = new LibraryDto(
                library.getId(),
                library
                        .getUserBook()
                        .stream()
                        .map(book-> bookServiceClient.getBookById(book).getBody() )
                        .collect(Collectors.toList())
        );
        return libraryDto;
    }

    public LibraryDto createLibrary() {
        Library library = libraryRepository.save(new Library());
        return new LibraryDto(library.getId());
    }

    public void addBookToLibrary(AddBookRequest request) {
        bookServiceClient.getBookIdIsbn(request.getIsbn());
        String bookId = bookServiceClient.getBookIdIsbn(request.getIsbn()).getBody().getId();
        Library library = libraryRepository.findById(request.getId()).orElseThrow(
                () -> new LibraryNotFoundException("Library could not found: " + request.getId()));
        library.getUserBook().add(bookId);
        libraryRepository.save(library);
    }


    public List<String> getAllLibraries() {
        return libraryRepository.findAll().stream().map(library -> library.getId()).collect(Collectors.toList());
    }
}
