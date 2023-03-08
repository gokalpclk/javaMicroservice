package com.outplay.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibraryDto {
    private String id;
    private List<BookDto> userBookList;

    public LibraryDto(String id) {
        this.id = id;
    }
}
