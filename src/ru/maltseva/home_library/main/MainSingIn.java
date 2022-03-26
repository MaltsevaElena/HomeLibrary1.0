package ru.maltseva.home_library.main;

import ru.maltseva.home_library.aController.authorization.*;
import ru.maltseva.home_library.aController.authorization.implEnterToConsoleCommand.EnterAuthorization;
import ru.maltseva.home_library.aController.authorization.implEnterToConsoleCommand.EnterRegistration;
import ru.maltseva.home_library.aController.authorization.implEnterToConsoleMenu.EnterNumberMenu;
import ru.maltseva.home_library.view.Menu;
import ru.maltseva.home_library.view.impl.MenuSingIn;

public class MainSingIn {

    public static void start() {
        Menu menu;

        ControllerProvider controllerProvider;
        Controller controller;

        EnterToConsoleMenu enterMenu;
        EnterToConsoleCommand enterCommand;

        String request;
        int responseMenu;
        int result;

        boolean resultSingIn = false;

       //вывели на экран приветствие
        menu = new MenuSingIn();
        menu.menuCommand();

        //запросили у пользователя номер команды
        enterMenu = new EnterNumberMenu();
        responseMenu = enterMenu.enterNumberMenu(2);

        if (responseMenu == 1) {
            enterCommand = new EnterAuthorization();

        } else {
            enterCommand = new EnterRegistration();
        }

        while (!resultSingIn){ //если команда завершиться с ошибкой, начать ввод данных снова

            //Authorization - login=malceva - password=1234
            request =enterCommand.enterData().toString();
            //создадим контроллер, он создал провайдер, теперь нужно передать строку для вызова нужного класса
            controllerProvider = ControllerProvider.getInstance();
            controller= controllerProvider.getController();

            //передали строку в контроллер
            resultSingIn = controller.doAction(request);

        }
        MainBook.start();
    }
}
