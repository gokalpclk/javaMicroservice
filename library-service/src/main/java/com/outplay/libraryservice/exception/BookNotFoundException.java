package com.outplay.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    private ExceptionMessage exceptionMessage;

    public BookNotFoundException(String message){
        super(message);
    }

    public BookNotFoundException(String message, ExceptionMessage exceptionMessage){
        super(message);
        this.exceptionMessage = exceptionMessage;
    }
    public BookNotFoundException( ExceptionMessage exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage(){
        return exceptionMessage;
    }

}
