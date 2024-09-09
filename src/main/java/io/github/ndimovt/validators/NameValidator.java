package io.github.ndimovt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates different names
 */
public class NameValidator {
    /**
     * Validates team name
     * @param teamName String parameter to be validated
     * @return String object or throws exception
     */
    public static String validateTeamName(String teamName) {
        String pattern = "[a-zA-Z ]+$";
        if (isInputValid(pattern, teamName) && !teamName.isEmpty() && !teamName.isBlank()) {
            return teamName;
        }
        throw new IllegalArgumentException("Team name can't contain letters, symbols or empty spaces!");
    }

    /**
     * Validates player name
     * @param name String parameter to be validated
     * @return String object or throws exception
     */
    public static String validatePlayerName(String name) {
        String pattern = "[\\d\\!\\@\\.\\$\\%\\^\\#\\&\\,\\*\\[\\]\\{\\}\\+\\=\\~\\?\\_\\<\\>\\;\\:]+|\\s{6,}";
        if(!isInputValid(pattern, name) && !name.isEmpty() && !name.isBlank()){
            return name;
        }
        throw new IllegalArgumentException("Invalid name");
    }

    /**
     * Validates team manager name
     * @param name String parameter to be validated
     * @return String object or throws exception
     */
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
