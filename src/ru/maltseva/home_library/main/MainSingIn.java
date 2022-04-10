package ru.maltseva.home_library.main;

import ru.maltseva.home_library.aController.*;
import ru.maltseva.home_library.aController.implCreationClient.CreationUserImpl;
import ru.maltseva.home_library.aController.implEnterToConsoleCommand.EnterAuthorization;
import ru.maltseva.home_library.aController.implEnterToConsoleCommand.EnterRegistration;
import ru.maltseva.home_library.aController.implEnterToConsoleMenu.EnterNumberMenu;
import ru.maltseva.home_library.entity.User;
import ru.maltseva.home_library.view.MenuSingIn;
import ru.maltseva.home_library.view.impl.MenuSingInImp;

public class MainSingIn {

    public static void start() {
        MenuSingIn menuSingIn;

        ControllerProvider controllerProvider;
        Controller controller;

        EnterToConsoleMenu enterMenu;
        EnterToConsoleCommand enterCommand;

        String request = null;
        int responseMenu;
        int result;

        boolean resultSingIn = false;

        CreationUser creationUser;
        User user;

        //вывели на экран приветствие
        menuSingIn = new MenuSingInImp();
        menuSingIn.menuCommand();

        //запросили у пользователя номер команды
        enterMenu = new EnterNumberMenu();
        responseMenu = enterMenu.enterNumberMenu(2);

        if (responseMenu == 1) {
            enterCommand = new EnterAuthorization();

        } else {
            enterCommand = new EnterRegistration();
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
