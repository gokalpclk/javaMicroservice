package com.outplay.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handle(BookNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
