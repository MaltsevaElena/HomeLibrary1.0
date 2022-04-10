package ru.maltseva.home_library.bService.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorBook {

    private static ValidatorBook instance = new ValidatorBook();

    public ValidatorBook() {
    }

    public static ValidatorBook getInstance() {
        return instance;
    }

    /*
     * ID:
     * Length from 1 to 5 digits;
     * Consists only of numbers.
     */
    public boolean isID(String request) {
        Pattern pattern = Pattern.compile("\\d{1,5}");
        Matcher matcher = pattern.matcher(request);

        return !matcher.matches();
    }

    /*
     * Name:
     * Length from 1 to 30 characters.
     * Can contain any character.
     */

    public boolean isName(String request) {

        Pattern pattern = Pattern.compile(".{1,30}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * Author:
     * Length from 3 to 20 characters.
     * Consists only alphanumeric character, number, space or underscore.
     */

    public boolean isAuthor(String request) {

        Pattern pattern = Pattern.compile("((\\S+)(\\s*)(\\S+)){3,20}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * Year:
     * Length from 2 to 4 digits;
     * Consists only of numbers.
     */
    public boolean isYear(String request) {
        Pattern pattern = Pattern.compile("\\d{2,4}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * TypeBook:
     */

    public boolean isTypeBook(String request) {
        if (request.equalsIgnoreCase("Бумажная книга")) {
            return true;
        } else return request.equalsIgnoreCase("Электронная книга");
    }


    /*
     * Description:
     * Length from 1 to 60 characters.
     * Can contain any character.
     */
    public boolean isDescription(String request) {

        Pattern pattern = Pattern.compile(".{1,60}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }
}