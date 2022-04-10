package ru.maltseva.home_library.aController.implEnterToConsoleCommand;

import ru.maltseva.home_library.aController.EnterToConsoleCommand;
import ru.maltseva.home_library.bService.util.ValidatorBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterDeleteBook implements EnterToConsoleCommand {
    private final ValidatorBook validator = ValidatorBook.getInstance();

    @Override
    public StringBuffer enterData() {
        StringBuffer response;
        String validationLine;

        response = new StringBuffer("DeleteBook - ");

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ID книги, которую необходимо удалить:");

        try {
            validationLine = reader.readLine();

            while (validator.isID(validationLine)) {
                System.out.println("""
                        ID книги может состоять только из цифр
                        Длина от 1 до 5 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }
            response.append("id=").append(validationLine);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}