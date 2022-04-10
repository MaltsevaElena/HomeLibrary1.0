package ru.maltseva.home_library.aController.implEnterToConsoleCommand;

import ru.maltseva.home_library.aController.EnterToConsoleCommand;
import ru.maltseva.home_library.bService.util.ValidatorAuthentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterAuthorization implements EnterToConsoleCommand {
    private final ValidatorAuthentication validator = ValidatorAuthentication.getInstance();

    @Override
    public StringBuffer enterData() {
        StringBuffer response;
        String validationLine;

        response = new StringBuffer("Authorization - ");

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Для входа в программу введите");
        System.out.println("Логин: ");

        try {
            validationLine = reader.readLine();

            while (!validator.isLogin(validationLine)) {
                System.out.println("""
                        Логин должен начинаться с латинского символа.\s
                        Не может содержать цифры и пробельный символ. Длина от 5 до 15 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }
            response.append("login=").append(validationLine).append(" - ");

            System.out.println("Пароль: ");
            validationLine = reader.readLine();

            while (!validator.isPassword(validationLine)) {
                System.out.println("""
                        Пароль должен содержать хотя бы одну цифру, один символ в нижнем и верхнем регистре,
                        один спец.символ [@#$%^&+=], и не содержать пробелов.
                        Длина пароля от 8 до 20 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }
            validationLine = PasswordEncryption.encryprion(validationLine).toString();
            response.append("password=").append(validationLine);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
