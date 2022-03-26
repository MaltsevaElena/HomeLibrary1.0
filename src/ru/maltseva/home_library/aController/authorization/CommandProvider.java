package ru.maltseva.home_library.aController.authorization;

import ru.maltseva.home_library.aController.authorization.implCommand.Authorization;
import ru.maltseva.home_library.aController.authorization.implCommand.Registration;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands;
    private static CommandProvider instance = null;

    private CommandProvider() {
        commands = new HashMap<>();
        commands.put("Authorization", new Authorization());
        commands.put("Registration", new Registration());
       // commands.put("ViewingBooks", new ViewingBooks());
       // commands.put("SearchBook", new SearchBook());
    }

    public static CommandProvider getInstance() {
        if (instance == null) {
            instance = new CommandProvider();
        }
        return instance;
    }

    public Command getCommands(String commandName) {
        Command command;
        command = commands.get(commandName);

        return command;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
