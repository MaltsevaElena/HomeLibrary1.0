package ru.maltseva.home_library.main;

import ru.maltseva.home_library.aController.authorization.*;
import ru.maltseva.home_library.aController.authorization.implCreationClient.CreationClientImpl;
import ru.maltseva.home_library.aController.authorization.implEnterToConsoleCommand.EnterAuthorization;
import ru.maltseva.home_library.aController.authorization.implEnterToConsoleCommand.EnterRegistration;
import ru.maltseva.home_library.aController.authorization.implEnterToConsoleMenu.EnterNumberMenu;
import ru.maltseva.home_library.entity.Client;
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

        CreationClient creationClient;
        Client client;

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
            //создадим контроллер, он создал провайдер, теперь нужно передать строку для вызова нужного класса
            controllerProvider = ControllerProvider.getInstance();
            controller = controllerProvider.getController();

            //передали строку в контроллер
            resultSingIn = controller.doAction(request);

        }

        creationClient = CreationClientImpl.getInstance();
        client = creationClient.creationClient(request);

        MainBook.start(client);
    }
}
