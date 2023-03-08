package com.outplay.libraryservice.controller;

import com.outplay.libraryservice.dto.AddBookRequest;
import com.outplay.libraryservice.dto.LibraryDto;
import com.outplay.libraryservice.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }
}
