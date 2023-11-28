package com.example.springlearn.exceptions;

public class PersonIsNotExistException extends RuntimeException {
    public PersonIsNotExistException(String message) {
        super(message);
    }
}
