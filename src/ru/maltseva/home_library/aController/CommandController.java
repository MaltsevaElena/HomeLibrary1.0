package ru.maltseva.home_library.aController;

public class CommandController implements Controller {

    private final CommandProvider commandProvider = CommandProvider.getInstance();

    @Override
    public boolean doAction(String request) {
        // получили логин
        String commandName;
        Command command;
        boolean response;


        commandName = request.split(" - ")[0];
        //выделили название команды
        command = commandProvider.getCommands(commandName);
        //запросили команду
        response = command.execute(request); // результат авторизации (добро пожаловать или не верный лог)
        // в команду передали введеную строку

        return response;
    }
}
