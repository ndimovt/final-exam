package io.github.ndimovt.handler;

import io.github.ndimovt.exception.InvalidDateFormatException;
import io.github.ndimovt.exception.InvalidFileFormatException;
import io.github.ndimovt.exception.InvalidFileTypeException;
import io.github.ndimovt.exception.MissingFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Handle exceptions globally
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handle InvalidFileTypeException
     * @param e InvalidFileTypeException
     * @return ResponseEntity
     */
    @ExceptionHandler(InvalidFileTypeException.class)
    public ResponseEntity<String> wrongFile(InvalidFileTypeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Handle InvalidFileFormatException
     * @param e InvalidFileFormatException
     * @return ResponseEntity
     */
    @ExceptionHandler(InvalidFileFormatException.class)
    public ResponseEntity<String> wrongFileFormat(InvalidFileFormatException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle FileNotFoundException
     * @param e FileNotFoundException
     * @return ResponseEntity
     */
    @ExceptionHandler(MissingFileException.class)
    public ResponseEntity<String> missingFile(FileNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handle IOException
     * @param e IOException
     * @return ResponseEntity
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> inaccessibleDatabase(IOException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handle InvalidDateFormatException
     * @param e InvalidDateFormatException
     * @return ResponseEntity
     */
    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<String> wrongDateFormat(InvalidDateFormatException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Handle IllegalArgumentException
     * @param e IllegalArgumentException
     * @return ResponseEntity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> invalidData(IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * Handle NumberFormatExceptio
     * @param e NumberFormatException
     * @return ResponseEntity
     */
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> invalidId(NumberFormatException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * Handle ArrayIndexOutOfBoundsException
     * @param e ArrayIndexOutOfBoundsException
     * @return ResponseEntity
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> invalidLength(ArrayIndexOutOfBoundsException e){
        return new ResponseEntity<>("File is empty or have empty rows!", HttpStatus.CONFLICT);
    }
}
