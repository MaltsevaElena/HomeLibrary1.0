package ru.maltseva.home_library.main;

import ru.maltseva.home_library.controller.*;
import ru.maltseva.home_library.entity.Role;
import ru.maltseva.home_library.entity.User;
import ru.maltseva.home_library.view.MenuBook;
import ru.maltseva.home_library.view.ViewProvider;

public class MainBook {

    public static void start(User user) {
        Controller controller;
        ControllerProvider controllerProvider;

        EnterToConsoleProvider enterToConsoleProvider;
        EnterToConsoleMenu enterToConsoleMenu;
        EnterToConsoleCommand enterCommand;

        Role role;

        ViewProvider viewProvider;

        boolean resultBookAction;
        String request = null;
        int numberMenu;

        role = user.getUserRole();

        viewProvider = ViewProvider.getInstance();
        MenuBook menuBook = viewProvider.getMenuBook();
        menuBook.menuCommandBook(role);

        enterToConsoleProvider = EnterToConsoleProvider.getInstance();
        enterToConsoleMenu = enterToConsoleProvider.getEnterToConsoleMenu();

        if (role.equals(Role.USER)) {
            numberMenu = enterToConsoleMenu.enterNumberMenu(3);
        } else {
            numberMenu = enterToConsoleMenu.enterNumberMenu(5);
        }

        switch (numberMenu) {
            case 1 -> request = "BrowsingBook";
            case 2 -> {
                enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterSearchBook");
                request = enterCommand.enterData().toString();
            }
            case 3 -> {
                enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterAddBook");
                request = enterCommand.enterData().append(user.getUserRole().toString()).toString();

            }
            case 4 -> {
                enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterEditingBook");
                request = enterCommand.enterData().toString();
            }
            case 5 -> {
                enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterDeleteBook");
                request = enterCommand.enterData().toString();
            }
            default -> System.out.println("Команда не найдена!");
        }

        controllerProvider = ControllerProvider.getInstance();
        controller = controllerProvider.getController();

        resultBookAction = controller.doAction(request);
        System.out.println("Результат выполнения команды: "+ resultBookAction);
    }
}
