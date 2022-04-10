package ru.maltseva.home_library.aController;

import ru.maltseva.home_library.aController.implEnterToConsoleCommand.*;
import ru.maltseva.home_library.aController.implEnterToConsoleMenu.EnterNumberMenu;

import java.util.HashMap;
import java.util.Map;

public class EnterToConsoleProvider {
    private final Map<String, EnterToConsoleCommand> enterToConsoleCommandMap;
    private final EnterToConsoleMenu enterToConsoleMenu;

    private static EnterToConsoleProvider instance = new EnterToConsoleProvider();

    public EnterToConsoleProvider() {
        enterToConsoleMenu = new EnterNumberMenu();
        enterToConsoleCommandMap = new HashMap<>();
        enterToConsoleCommandMap.put("EnterAuthorization", new EnterAuthorization());
        enterToConsoleCommandMap.put("EnterRegistration", new EnterRegistration());
        enterToConsoleCommandMap.put("EnterSearchBook", new EnterSearchBook());
        enterToConsoleCommandMap.put("EnterAddBook", new EnterAddBook());
        enterToConsoleCommandMap.put("EnterEditingBook", new EnterEditingBook());
        enterToConsoleCommandMap.put("EnterDeleteBook", new EnterDeleteBook());
    }

    public static EnterToConsoleProvider getInstance() {
        return instance;
    }
    public EnterToConsoleCommand getEnterToConsoleCommand(String commandName) {
        EnterToConsoleCommand enterToConsoleCommand;
        enterToConsoleCommand = enterToConsoleCommandMap.get(commandName);

        return enterToConsoleCommand;
    }

    public Map<String, EnterToConsoleCommand> getEnterToConsoleCommandMap() {
        return enterToConsoleCommandMap;
    }

    public EnterToConsoleMenu getEnterToConsoleMenu() {
        return enterToConsoleMenu;
    }
}
