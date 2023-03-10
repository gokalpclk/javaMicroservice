package com.outplay.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
