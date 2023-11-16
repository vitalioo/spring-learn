package com.example.spring_learn.exceptions;

public class PersonIsAlreadyExistException extends RuntimeException {
    public PersonIsAlreadyExistException(String message) {
        super(message);
    }
}
