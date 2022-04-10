package ru.maltseva.home_library.aController.implCommand;


import ru.maltseva.home_library.aController.Command;
import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.view.AnswerForUser;
import ru.maltseva.home_library.view.ViewProvider;

public class Authorization implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private  final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        ClientService clientService;
        AnswerForUser answerForUser;

        String[] params;
        boolean answer = false;

        params = request.split(" - ");

        String login = params[1];
        String password = params[2];

        clientService = serviceProvider.getClientService();

        try {
            answer = clientService.verificationParam(login, password);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        answerForUser = viewProvider.getAnswerForUser();
        answerForUser.UserAnswer(this.getClass().getSimpleName(), answer);

        return answer;
    }
}