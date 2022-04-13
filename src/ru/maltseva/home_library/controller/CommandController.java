package ru.maltseva.home_library.controller;

public class CommandController implements Controller {

    private final CommandProvider commandProvider = CommandProvider.getInstance();

    @Override
    public boolean doAction(String request) {
        String commandName;
        Command command;
        boolean response;

        commandName = request.split(" - ")[0];
        command = commandProvider.getCommands(commandName);
        response = command.execute(request);

        return response;
    }
}