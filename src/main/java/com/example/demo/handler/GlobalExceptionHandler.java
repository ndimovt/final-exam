package com.example.demo.handler;

import com.example.demo.exception.InvalidDateFormatException;
import com.example.demo.exception.InvalidFileFormatException;
import com.example.demo.exception.InvalidFileTypeException;
import com.example.demo.exception.MissingFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidFileTypeException.class)
    public ResponseEntity<String> wrongFile(InvalidFileTypeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(InvalidFileFormatException.class)
    public ResponseEntity<String> wrongFileFormat(InvalidFileFormatException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MissingFileException.class)
    public ResponseEntity<String> missingFile(FileNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> inaccessibleDatabase(IOException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<String> wrongDateFormat(InvalidDateFormatException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

}
