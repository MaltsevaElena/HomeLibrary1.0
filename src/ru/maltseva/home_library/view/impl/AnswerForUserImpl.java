package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.AnswerForUser;

public class AnswerForUserImpl implements AnswerForUser {

    @Override
    public void UserAnswer(String command, boolean result) {
        if ("Authorization".equals(command)) {
            if (result) {
                System.out.println("Добро пожаловать!");
            } else {
                System.out.println("Неверный логин и пароль");
            }
        } else if ("Registration".equals(command)) {
            if (result) {
                System.out.println("Регистрация прошла успешна. \n Добро пожаловать!");
            } else {
                System.out.println("Ошибка регистрации");
            }
        }
    }
}
