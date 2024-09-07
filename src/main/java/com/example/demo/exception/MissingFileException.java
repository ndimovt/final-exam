package com.example.demo.exception;

public class MissingFileException extends RuntimeException{
    public MissingFileException(String message) {
        super(message);
    }
}
