package com.outplay.libraryservice.exception;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
public class LibraryNotFoundException extends RuntimeException {


    public LibraryNotFoundException(String message) {
        super(message);
    }
}
