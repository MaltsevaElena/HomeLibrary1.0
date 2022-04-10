package ru.maltseva.home_library.aController.implEnterToConsoleMenu;

import ru.maltseva.home_library.aController.EnterToConsoleMenu;

import java.util.Scanner;

public class EnterNumberMenu implements EnterToConsoleMenu {

    @Override
    public int enterNumberMenu(int maxItemMenu) {

        int number;

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        do {
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число. Повторите попытку.");
                sc.next();
            }
            number = sc.nextInt();
            if (number < 1 || number > maxItemMenu) {
                System.out.println("Вы ввели не верную команду. Повторите ввод.");
            }
        }
        while (number < 1 || number > maxItemMenu);

        return number;
    }
}
