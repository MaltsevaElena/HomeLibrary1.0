package ru.maltseva.home_library.main;

import ru.maltseva.home_library.aController.Controller;
import ru.maltseva.home_library.aController.ControllerProvider;
import ru.maltseva.home_library.aController.EnterToConsoleCommand;
import ru.maltseva.home_library.aController.EnterToConsoleMenu;
import ru.maltseva.home_library.aController.implEnterToConsoleCommand.*;
import ru.maltseva.home_library.aController.implEnterToConsoleMenu.EnterNumberMenu;
import ru.maltseva.home_library.entity.Role;
import ru.maltseva.home_library.entity.User;
import ru.maltseva.home_library.view.MenuBook;
import ru.maltseva.home_library.view.impl.MenuBookImp;

public class MainBook {


    public static void start(User user) {
        EnterToConsoleCommand enterCommand; // делать синглтоном или провайдер
        ControllerProvider controllerProvider;
        Controller controller;
        boolean resultBookAction;
        String request = null;

        Role role = user.getUserRole();

        MenuBook menuBook = new MenuBookImp();
        menuBook.menuCommandBook(role);

        EnterToConsoleMenu enterToConsoleMenu = new EnterNumberMenu();// делать синглтоном или провайдер
        int numberMenu;

        if (role.equals(Role.USER)) {
            numberMenu = enterToConsoleMenu.enterNumberMenu(3);
        } else {
            numberMenu = enterToConsoleMenu.enterNumberMenu(5);
        }

        switch (numberMenu) {
            case 1 -> request = "BrowsingBook";
            case 2 -> {
                enterCommand = new EnterSearchBook();
                request = enterCommand.enterData().toString();
            }
            case 3 -> {
                enterCommand = new EnterAddBook();
                request = enterCommand.enterData().toString();
            }
            case 4 -> {
                enterCommand = new EnterEditingBook();
                request = enterCommand.enterData().toString();
            }
            case 5 -> {
                enterCommand = new EnterDeleteBook();
                request = enterCommand.enterData().toString();
            }
            default -> System.out.println("Команда не найдена!");
        }

        controllerProvider = ControllerProvider.getInstance();
        controller = controllerProvider.getController();

        //передали строку в контроллер
        resultBookAction = controller.doAction(request);
        System.out.println("Результат выполнения комманды: "+ resultBookAction);
    }
}
