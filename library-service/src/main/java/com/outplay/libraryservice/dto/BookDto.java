package com.outplay.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private BookIdDto id;
    private String title;
    private int year;
    private String author;
    private String pressName;

    public BookDto(BookIdDto id) {
        this.id = id;
    }
}
