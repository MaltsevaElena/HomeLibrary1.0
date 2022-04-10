package ru.maltseva.home_library.main;

import ru.maltseva.home_library.aController.*;
import ru.maltseva.home_library.aController.implCreationClient.CreationUserImpl;
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

        //вывели на экран приветствие
        viewProvider = ViewProvider.getInstance();
        menuSingIn = viewProvider.getMenuSingIn();
        menuSingIn.menuCommand();

        //запросили у пользователя номер команды
        enterToConsoleProvider= EnterToConsoleProvider.getInstance();
        enterMenu = enterToConsoleProvider.getEnterToConsoleMenu();
        responseMenu = enterMenu.enterNumberMenu(2);

        if (responseMenu == 1) {
            enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterAuthorization");

        } else {
            enterCommand = enterToConsoleProvider.getEnterToConsoleCommand("EnterRegistration");
        }

        while (!resultSingIn) { //если команда завершиться с ошибкой, начать ввод данных снова

            //Authorization - login=malceva - password=1234
            request = enterCommand.enterData().toString();
            //создадим контроллер, он создал провайдер
            controllerProvider = ControllerProvider.getInstance();
            controller = controllerProvider.getController();

            //передали строку в контроллер
            resultSingIn = controller.doAction(request);

        }

        creationUser = CreationUserImpl.getInstance();
        user = creationUser.creationClient(request);

        MainBook.start(user);
    }
}
