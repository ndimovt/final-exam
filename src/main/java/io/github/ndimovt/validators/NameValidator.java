package io.github.ndimovt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {
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

    private static boolean isInputValid(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
