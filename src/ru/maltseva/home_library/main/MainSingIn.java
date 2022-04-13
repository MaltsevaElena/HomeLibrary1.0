package ru.maltseva.home_library.main;

import ru.maltseva.home_library.controller.*;
import ru.maltseva.home_library.controller.implCreationClient.CreationUserImpl;
import ru.maltseva.home_library.entity.User;
import ru.maltseva.home_library.view.MenuSingIn;
import ru.maltseva.home_library.view.ViewProvider;


public class MainSingIn {

    public static void start() {
        MenuSingIn menuSingIn;

        ControllerProvider controllerProvider;
        Controller controller;
        ViewProvider viewProvider;

        EnterToConsoleMenu enterMenu;
        EnterToConsoleCommand enterCommand;
        EnterToConsoleProvider enterToConsoleProvider;

        String request = null;
        int responseMenu;
        boolean resultSingIn = false;

        CreationUser creationUser;
        User user;

        viewProvider = ViewProvider.getInstance();
        menuSingIn = viewProvider.getMenuSingIn();
        menuSingIn.menuCommand();


        enterToConsoleProvider = EnterToConsoleProvider.getInstance();
        enterMenu = enterToConsoleProvider.getEnterToConsoleMenu();
        responseMenu = enterMenu.enterNumberMenu(2);

        if (responseMenu == 1) {
            enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterAuthorization");

        } else {
            enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterRegistration");
        }

        while (!resultSingIn) {

            request = enterCommand.enterData().toString();

            controllerProvider = ControllerProvider.getInstance();
            controller = controllerProvider.getController();

            resultSingIn = controller.doAction(request);
        }

        creationUser = CreationUserImpl.getInstance();
        user = creationUser.creationClient(request);

        MainBook.start(user);
    }
}
