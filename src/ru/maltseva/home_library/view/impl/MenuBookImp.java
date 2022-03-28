package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.entity.Role;
import ru.maltseva.home_library.view.MenuBook;

public class MenuBookImp implements MenuBook {
    @Override
    public void menuCommandBook(Role role) {
        if (role == Role.USER) {
            System.out.println("Выберите следующий пункт меню: ");
            System.out.println("1 - Просмотр книг в каталоге.");
            System.out.println("2 - Поиск книг в каталоге.");
            System.out.println("3 - Добавить книгу."); //переслать администратору на емаил.
            
        } else if (role == Role.ADMIN) {
            System.out.println("Выберите следующий пункт меню: ");
            System.out.println("1 - Просмотр книг в каталоге.");
            System.out.println("2 - Поиск книг в каталоге.");
            System.out.println("3 - Добавить книгу.");
            System.out.println("4 - Добавить описание книги."); //+рассылка на емаил
            System.out.println("5 - Редактирование каталога????");
        }
    }
}