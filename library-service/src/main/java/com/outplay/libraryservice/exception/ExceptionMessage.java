package com.outplay.libraryservice.exception;

/**
 * @author Gokalp on 9.03.2023
 * @project javaMicroservice
 */
public record ExceptionMessage(String timestamp,
                               int status,
                               String error,
                               String message,
                               String path) {

}
