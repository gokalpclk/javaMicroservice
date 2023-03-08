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
public class BookIdDto {
    private String id;
    private String isbn;
}
