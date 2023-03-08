package com.outplay.libraryservice.exception;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s) {
        super (s);

    }
}
