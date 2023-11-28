package com.example.springlearn.exceptions;

public class PersonIsAlreadyExistException extends RuntimeException {
    public PersonIsAlreadyExistException(String message) {
        super(message);
    }
}
