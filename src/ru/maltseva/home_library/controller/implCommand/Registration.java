package ru.maltseva.home_library.controller.implCommand;

import ru.maltseva.home_library.controller.Command;
import ru.maltseva.home_library.service.ClientService;
import ru.maltseva.home_library.service.ServiceException;
import ru.maltseva.home_library.service.ServiceProvider;
import ru.maltseva.home_library.view.AnswerForUser;
import ru.maltseva.home_library.view.ViewProvider;

public class Registration implements Command {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        ClientService clientService;
        AnswerForUser answerForUser;

        boolean answer = false;

        clientService = serviceProvider.getClientService();

        try {
            answer = clientService.registration(request);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        answerForUser = viewProvider.getAnswerForUser();
        answerForUser.UserAnswer(this.getClass().getSimpleName(), answer);

        return answer;
    }
}
