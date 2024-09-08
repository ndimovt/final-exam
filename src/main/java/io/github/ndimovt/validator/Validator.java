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
    private static final String NUMBER_PATTERN ="[\\d]";
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
    public static String validatePlayerPosition(String position){
        String pattern = "^[A-Z]{2}$";
        if(isInputValid(pattern, position) && !position.isBlank() && !position.isEmpty()){
            return position;
        }
        throw new IllegalArgumentException("Player position can't contain letters or special symbols!");
    }
    public static char validateTeamGroup(char teamGroup){
        if(Character.isLetter(teamGroup) && teamGroup != '\0'){
            return teamGroup;
        }
        throw new NumberFormatException("Groups can consist only one letter and no digits!");
    }
    public static int validateTeamNumber(String teamNumber){
        if(isInputValid(NUMBER_PATTERN, teamNumber) && teamNumber.length() > 0 && Integer.parseInt(teamNumber) < 100 && !teamNumber.isBlank()){
            return Integer.parseInt(teamNumber);
        }
        throw new NumberFormatException("Team number can't contain letters or special symbols and can't be less than 0!");
    }
    public static String validateMaxPlayingTime(String time){
        String pattern = "^(NULL|[1-9]$|[1-8][0-9]$|90)$";
        if(isInputValid(pattern, time) && !time.isEmpty() && !time.isBlank()){
            return time;
        }
        throw new IllegalArgumentException("Time can be only number, NULL, or be in brackets!");
    }
    public static int validatePlayingTime(String time){
        if(isInputValid(NUMBER_PATTERN, time) && time.length() > 0 && Integer.parseInt(time) < 90 && !time.isBlank()){
            return Integer.parseInt(time);
        }
        throw new NumberFormatException("Time can't be less than 0 or bigger than 90. Can contain only numbers!");
    }

    public static String validateTeamName(String teamName) {
        String pattern = "[a-zA-Z ]+$";
        if (isInputValid(pattern, teamName) && !teamName.isEmpty() && !teamName.isBlank()) {
            return teamName;
        }
        throw new IllegalArgumentException("Team name can't contain letters, symbols or empty spaces!");
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
        if(isInputValid(NUMBER_PATTERN, id) && id.length() > 0 && Long.parseLong(id) < Long.MAX_VALUE && !id.isBlank()){
            return Long.parseLong(id);
        }
        throw new NumberFormatException("Id can't contain letters or special symbols and can't be less than 0!");
    }
    public static String validateScore(String score){
        String pattern = "^[\\d\\-\\(\\)]+$";
        if(isInputValid(pattern, score) && !score.isEmpty() && !score.isBlank()){
            return score;
        }
        throw new NumberFormatException("Score can contain only numbers, - , or (  ) !");
    }
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

    private static boolean isInputValid(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
