package io.github.ndimovt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositionAndGroupValidator {

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

    private static boolean isInputValid(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
