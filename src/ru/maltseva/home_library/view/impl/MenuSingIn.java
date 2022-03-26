package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.Menu;

public class MenuSingIn implements Menu {
    @Override
    public void menuCommand() {
        System.out.println("Добро пожаловать в программу учета книг.");
        System.out.println("Выберите следующий пункт меню: ");
        System.out.println("1 - Авторизация.");
        System.out.println("2 - Регистрация.");
    }
}