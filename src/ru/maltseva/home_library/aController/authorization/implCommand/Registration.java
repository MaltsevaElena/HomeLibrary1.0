package ru.maltseva.home_library.aController.authorization.implCommand;

import ru.maltseva.home_library.aController.authorization.Command;
import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.view.AnswerForUser;
import ru.maltseva.home_library.view.ViewProvider;

public class Registration implements Command {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private  final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        ClientService clientService;
        AnswerForUser answerForUser;

        boolean answer = false;

        clientService = serviceProvider.getClientService();

        try {
            answer = clientService.registration(request);
        } catch (ServiceException e) {
            // ошибка регистрации
            e.printStackTrace();
        }

        answerForUser = viewProvider.getUserActionView();
        answerForUser.UserAnswer(this.getClass().getSimpleName(), answer);

        return answer;
    }
}
