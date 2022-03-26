package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.Menu;

public class MenuMain implements Menu {
    @Override
    public void menuCommand() {
            System.out.println("Выберите следующий пункт меню: ");
            System.out.println("1 - Просмотр книг в каталоге."); //постраничный просмотр
            System.out.println("2 - Поиск книг в каталоге.");
            System.out.println("3 - Добавить описание книги."); //+рассылка на емаил
            System.out.println("4 - Добавить книгу."); //переслать администратору на емаил. добавить для админа
    }
}
