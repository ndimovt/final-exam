package io.github.ndimovt.validators;

import io.github.ndimovt.exception.InvalidFileFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class DateValidator {
    private static List<DateTimeFormatter> supportedFormats = Arrays.asList(
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yy"),
            DateTimeFormatter.ofPattern("dd-M-yyyy"),
            DateTimeFormatter.ofPattern("d-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"));

    public static LocalDate validateDate(String dateString){
        if(dateString.isBlank() || dateString.isEmpty()){
            throw new IllegalArgumentException("Missing date record!");
        }
        for (DateTimeFormatter formatter : supportedFormats) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }
        throw new InvalidFileFormatException("Unsupported date format: " + dateString);
    }
}
