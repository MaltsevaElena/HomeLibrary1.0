package ru.maltseva.home_library.aController.implEnterToConsoleCommand;

import ru.maltseva.home_library.aController.EnterToConsoleCommand;
import ru.maltseva.home_library.bService.util.ValidatorBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterAddBook implements EnterToConsoleCommand {
    private final ValidatorBook validator = ValidatorBook.getInstance();

    @Override
    public StringBuffer enterData() {
        StringBuffer response;
        String validationLine;

        response = new StringBuffer("AddBook - ");

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Заполните поля новой книги:");
        System.out.println("Название книги: ");

        try {
            validationLine = reader.readLine();

            while (!validator.isName(validationLine)) {
                System.out.println("""
                        Название книги может содержать любой символ.\s
                        Длина от 1 до 30 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }
            response.append("name=").append(validationLine).append(" - ");

            System.out.println("Автор: ");
            validationLine = reader.readLine();

            while (!validator.isAuthor(validationLine)) {
                System.out.println("""
                        Поле автор может содержать Фамилию и Имя через пробел
                        Длина поля от 3 до 20 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }

            response.append("author=").append(validationLine).append(" - ");

            System.out.println("год: ");
            validationLine = reader.readLine();

            while (!validator.isYear(validationLine)) {
                System.out.println("""
                        Поле год может содержать только цифры
                        Длина от 2 до 4 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }

            response.append("year=").append(validationLine).append(" - ");

            System.out.println("Тип книги: Бумажная книга или Электронная книга");
            validationLine = reader.readLine();

            while (!validator.isTypeBook(validationLine)) {
                System.out.println("""
                        Поле /"тип книги/" может содержать только
                        Бумажная книга или
                        Электронная книга
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }

            response.append("typeBook=").append(validationLine).append(" - ");

            System.out.println("Описание книги: ");
            validationLine = reader.readLine();

            while (!validator.isDescription(validationLine)) {
                System.out.println("""
                        Поле /"Описание/" может содержать любой символ
                        Длина от 1 до 60 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }

            response.append("description=").append(validationLine).append(" - ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}