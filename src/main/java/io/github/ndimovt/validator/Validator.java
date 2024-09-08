package io.github.ndimovt.validator;

import io.github.ndimovt.exception.InvalidFileFormatException;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static List<DateTimeFormatter> supportedFormats = Arrays.asList(
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yy"),
            DateTimeFormatter.ofPattern("dd-M-yyyy"),
            DateTimeFormatter.ofPattern("d-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    public static boolean isFileFormatValid (MultipartFile file){
        String filename = file.getOriginalFilename();
        return filename != null && filename.toLowerCase().endsWith(".csv");
    }
    public static String validatePlayerName(String name) {
        String pattern = "[\\d\\!\\@\\.\\$\\%\\^\\#\\&\\,\\*\\[\\]\\{\\}\\+\\=\\~\\?\\_\\<\\>\\;\\:]+|\\s{6,}";
        if(!isInputValid(pattern, name) && !name.isEmpty() && !name.isBlank()){
            return name;
        }
        throw new IllegalArgumentException("Invalid name");
    }
    public static String validateManagerName(String name){
        String pattern = "[\\d\\!\\@\\.\\$\\%\\^\\#\\&\\,\\*\\[\\]\\{\\}\\+\\=\\~\\?\\_\\(\\)\\<\\>\\;\\:]+|\\s{6,}";
        if(!isInputValid(pattern, name) && !name.isEmpty() && !name.isBlank()){
            return name;
        }
        throw new IllegalArgumentException("Invalid name");
    }
    public static long validateId(String id){
        String pattern = "[\\d]";
        if(isInputValid(pattern, id) && id.length() > 0 && Long.parseLong(id) <= Long.SIZE){
            return Long.parseLong(id);
        }
        throw new NumberFormatException("Id can't contain letters or special symbols and can't be less than 0!");
    }
    public static LocalDate validateDate(String dateString) throws InvalidFileFormatException {
        for (DateTimeFormatter formatter : supportedFormats) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }
        throw new InvalidFileFormatException("Unsupported date format: " + dateString);
    }

    private static boolean isInputValid(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
