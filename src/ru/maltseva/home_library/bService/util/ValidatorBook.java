package ru.maltseva.home_library.bService.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorBook {

    private static ValidatorBook instance = null;

    public ValidatorBook() {
    }

    public static ValidatorBook getInstance() {
        if (instance == null) {
            instance = new ValidatorBook();
        }
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

        return matcher.matches();
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
     * Length from 1 to 20 characters.
     * Consists only alphanumeric character or underscore.
     */

    public boolean isAuthor(String request) {

        Pattern pattern = Pattern.compile("\\w{1,20}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * Year:
     * Length from 1 to 4 digits;
     * Consists only of numbers.
     */
    public boolean isYear(String request) {
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

    /*
     * TypeBook:
     * Length from 4 to 20 characters.
     * Consists only alphanumeric character or underscore.
     */

    public boolean isTypeBook(String request) {

        Pattern pattern = Pattern.compile("^([A-Za-zА-Яа-я_]{4,20})$");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }


    /*
     * Description:
     * Length from 1 to 30 characters.
     * Can contain any character.
     */
    public boolean isDescription(String request) {

        Pattern pattern = Pattern.compile(".{1,30}");
        Matcher matcher = pattern.matcher(request);

        return matcher.matches();
    }

}
