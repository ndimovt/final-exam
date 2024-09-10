package io.github.ndimovt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates score, id and
 */

public class NumberAndPlayingTimeValidator {

    private static final String NUMBER_PATTERN ="[\\d]";

    /**
     * Validates the score of the match
     * @param score String parameter to be validated
     * @return String object or throws exception
     */
    public static String validateScore(String score){
        String pattern = "^[\\d\\-\\(\\)]+$";
        if(isInputValid(pattern, score) && !score.isEmpty() && !score.isBlank()){
            return score;
        }
        throw new NumberFormatException("Score can contain only numbers, - , or (  ) !");
    }

    /**
     * Validates id
     * @param id String parameter to be validated
     * @return long primitive or throws exception
     */

    public static long validateId(String id){
        if(isInputValid(NUMBER_PATTERN, id) && id.length() > 0 && Long.parseLong(id) < Long.MAX_VALUE && !id.isBlank()){
            return Long.parseLong(id);
        }
        throw new NumberFormatException("Id can't contain letters or special symbols and can't be less than 0!");
    }

    /**
     * Validates number under each player is known
     * @param teamNumber String parameter to be validated
     * @return int primitive or throws exception
     */
    public static int validateTeamNumber(String teamNumber){
        if(isInputValid(NUMBER_PATTERN, teamNumber) && teamNumber.length() > 0 && Integer.parseInt(teamNumber) < 100 && !teamNumber.isBlank()){
            return Integer.parseInt(teamNumber);
        }
        throw new NumberFormatException("Team number can't contain letters or special symbols and can't be less than 0!");
    }

    /**
     * Validates up to which minute the player was on the field
     * @param time String parameter to be validated
     * @return String object or throws exception
     */
    public static String validateMaxPlayingTime(String time){
        String pattern = "^(NULL|[1-9]$|[1-9][0-9]$|1[0-1][0-9]$|120)$";
        if(isInputValid(pattern, time) && !time.isEmpty() && !time.isBlank()){
            return time;
        }
        throw new IllegalArgumentException("Time can be only number, NULL, or be in brackets!");
    }

    /**
     * Validates from which minute the player was on the field
     * @param time String parameter to be validated
     * @return int primitive or throws exception
     */
    public static int validatePlayingTime(String time){
        if(isInputValid(NUMBER_PATTERN, time) && time.length() > 0 && Integer.parseInt(time) < 90 && !time.isBlank()){
            return Integer.parseInt(time);
        }
        throw new NumberFormatException("Time can't be less than 0 or bigger than 90. Can contain only numbers!");
    }
    private static boolean isInputValid(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
