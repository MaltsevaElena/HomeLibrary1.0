package ru.maltseva.home_library.controller.implEnterToConsoleCommand;

import ru.maltseva.home_library.controller.EnterToConsoleCommand;
import ru.maltseva.home_library.service.ClientService;
import ru.maltseva.home_library.service.ServiceException;
import ru.maltseva.home_library.service.ServiceProvider;
import ru.maltseva.home_library.service.util.ValidatorAuthentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterRegistration implements EnterToConsoleCommand {

    private final ServiceProvider provider = ServiceProvider.getInstance();
    private final ValidatorAuthentication validator = ValidatorAuthentication.getInstance();

    @Override
    public StringBuffer enterData() {
        ClientService clientService = provider.getClientService();

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer response;
        String validationLine;

        boolean verificationParam = false;
        boolean validationParam;

        System.out.println("Для регистрации в программе введите: ");
        System.out.println("Имя: ");

        response = new StringBuffer("Registration - ");
        try {
            validationLine = reader.readLine();

            while (!validator.isName(validationLine)) {
                System.out.println("""
                        Имя должно содержать только Латинские символы.
                        Длина от 3 до 15 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }
            response.append("name=").append(validationLine).append(" - ");

            System.out.println("E-mail: ");
            validationLine = reader.readLine();

            while (!validator.isEmail(validationLine)) {
                System.out.println("Не верный e-mail. Повторите ввод.");
                validationLine = reader.readLine();
            }
            response.append("e-mail=").append(validationLine).append(" - ");

            System.out.println("Логин: ");
            validationLine = reader.readLine();
            do {
                //Проверка логина на валидность
                validationParam = validator.isLogin(validationLine);
                if (validationParam) {

                    try {
                        // проверка, есть ли уже такой логин
                        verificationParam = clientService.verificationParam("login=" + validationLine);
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                    if (verificationParam) {
                        System.out.println("Такой Логин уже существует, введите другой Логин");
                        validationParam = false;
                        validationLine = reader.readLine();
                    }
                } else {
                    System.out.println("""
                            Логин должен начинаться с Латинского символа,\s
                            не может содержать цифры и пробельный символ. Длина от 5 до 15 символов.
                            Повторите ввод.""");
                    validationLine = reader.readLine();
                }
            }
            while (!validationParam);

            response.append("login=").append(validationLine).append(" - ");

            System.out.println("Пароль: ");
            validationLine = reader.readLine();

            while (!validator.isPassword(validationLine)) {
                System.out.println("""
                        Пароль должен содержать хотя бы одну цифру, один символ в нижнем и верхнем регистре,
                        один спец.символ [!@#$%^&+=.,] и не содержать пробелов.
                        Длина пароля от 8 до 20 символов.
                        Повторите ввод.""");
                validationLine = reader.readLine();
            }
            validationLine = PasswordEncryption.encryprion(validationLine).toString();
            response.append("password=").append(validationLine).append(" - ");

            System.out.println("Тип пользователя: Admin или User:");
            validationLine = reader.readLine();

            while (!validator.isRole(validationLine)) {
                System.out.println("Не верный тип пользователя.\n" +
                        "Введите: Admin или User.");
                validationLine = reader.readLine();
            }
            response.append("role=").append(validationLine);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
