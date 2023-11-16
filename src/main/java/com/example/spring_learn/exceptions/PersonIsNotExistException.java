package com.example.spring_learn.exceptions;

public class PersonIsNotExistException extends RuntimeException{
    public PersonIsNotExistException(String message) {
        super(message);
    }
}
