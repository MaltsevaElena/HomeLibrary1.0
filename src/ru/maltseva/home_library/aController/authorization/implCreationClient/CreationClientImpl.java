package ru.maltseva.home_library.aController.authorization.implCreationClient;

import ru.maltseva.home_library.aController.authorization.CreationClient;
import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.entity.Client;

public class CreationClientImpl implements CreationClient {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private static CreationClientImpl instance = new CreationClientImpl();

    private CreationClientImpl() {
    }

    public static CreationClientImpl getInstance() {
        return instance;
    }

    @Override
    public Client creationClient(String request) {
        ClientService clientService;
        Client client = null;

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
            client = clientService.clientCreation(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return client;
    }
}
