package com.example.demo.exception;

public class WrongFileFormatException extends RuntimeException{
    public WrongFileFormatException(String message) {
        super(message);
    }
}
