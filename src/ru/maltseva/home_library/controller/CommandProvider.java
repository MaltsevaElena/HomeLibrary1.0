package ru.maltseva.home_library.controller;

import ru.maltseva.home_library.controller.implCommand.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands;
    private static CommandProvider instance = null;

    private CommandProvider() {
        commands = new HashMap<>();
        commands.put("Authorization", new Authorization());
        commands.put("Registration", new Registration());
        commands.put("BrowsingBook", new BrowsingBook());
        commands.put("SearchBook", new SearchBook());
        commands.put("AddBook", new AddBook());
        commands.put("EditingBook", new EditingBook());
        commands.put("DeleteBook", new DeleteBook());

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
