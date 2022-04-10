package ru.maltseva.home_library.aController.implEnterToConsoleCommand;

import ru.maltseva.home_library.aController.EnterToConsoleCommand;
import ru.maltseva.home_library.aController.EnterToConsoleMenu;
import ru.maltseva.home_library.aController.implEnterToConsoleMenu.EnterNumberMenu;
import ru.maltseva.home_library.bService.util.ValidatorBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterEditingBook implements EnterToConsoleCommand {
    private final ValidatorBook validator = ValidatorBook.getInstance();

    @Override
    public StringBuffer enterData() {
        StringBuffer response;
        String validationLine;
        EnterToConsoleMenu enterToConsoleMenu;
        int numberMenu;

        response = new StringBuffer("EditingBook - ");

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите ID книги: ");

        try {
            validationLine = reader.readLine();
            while (validator.isID(validationLine)) {
                System.out.println("""
                        ID книги может содержать только цифры.\s
                        Длина от 1 до 5 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }
            response.append("id=").append(validationLine).append(" - ");

            System.out.println("Выберите поле для редактирования: ");
            System.out.println("""
                    1. Название книги.
                    2. Автор книги.
                    3. Год издания.
                    4. Тип книги.
                    5. Описание.
                    ->\040""");
            enterToConsoleMenu = new EnterNumberMenu();
            numberMenu = enterToConsoleMenu.enterNumberMenu(5);

            switch (numberMenu) {
                case 1 -> {
                    System.out.println("Название книги: ");
                    validationLine = reader.readLine();
                    while (!validator.isName(validationLine)) {
                        System.out.println("""
                                Название книги может содержать любой символ.\s
                                Длина от 1 до 30 символов.
                                Повторите ввод.""");
                        validationLine = reader.readLine();
                    }
                    response.append("name=").append(validationLine);
                }
                case 2 -> {
                    System.out.println("Автор: ");
                    validationLine = reader.readLine();
                    while (!validator.isAuthor(validationLine)) {
                        System.out.println("""
                                Поле автор может содержать Фамилию и Имя через пробел
                                Длина поля от 3 до 20 символов.
                                Повторите ввод.""");
                        validationLine = reader.readLine();
                    }
                    response.append("author=").append(validationLine);
                }
                case 3 -> {
                    System.out.println("год: ");
                    validationLine = reader.readLine();
                    while (!validator.isYear(validationLine)) {
                        System.out.println("""
                                Поле год может содержать только цифры
                                Длина от 2 до 4 символов.
                                Повторите ввод.""");
                        validationLine = reader.readLine();
                    }
                    response.append("year=").append(validationLine);
                }
                case 4 -> {
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
                    response.append("typeBook=").append(validationLine);
                }
                case 5 -> {
                    System.out.println("Описание книги: ");
                    validationLine = reader.readLine();
                    while (!validator.isDescription(validationLine)) {
                        System.out.println("""
                                Поле /"Описание/" может содержать любой символ
                                Длина от 1 до 60 символов.
                                Повторите ввод.""");
                        validationLine = reader.readLine();
                    }
                    response.append("description=").append(validationLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}