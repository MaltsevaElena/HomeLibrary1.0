package ru.maltseva.home_library.controller.implCreationClient;

import ru.maltseva.home_library.controller.CreationUser;
import ru.maltseva.home_library.service.ClientService;
import ru.maltseva.home_library.service.ServiceException;
import ru.maltseva.home_library.service.ServiceProvider;
import ru.maltseva.home_library.entity.User;

public class CreationUserImpl implements CreationUser {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private static CreationUserImpl instance = new CreationUserImpl();

    private CreationUserImpl() {
    }

    public static CreationUserImpl getInstance() {
        return instance;
    }

    @Override
    public User creationClient(String request) {
        ClientService clientService;
        User user = null;

        String[] params;
        String login = null;


        clientService = serviceProvider.getClientService();

        params = request.split(" - ");

        for (String param : params) {
            if (param.contains("login")) {
                login = param;
            }
        }
        try {
            user = clientService.clientCreation(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return user;
    }
}
