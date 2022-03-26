package ru.maltseva.home_library.aController.authorization;

import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.entity.Client;

public class CreationUser {
    //подумать что с ним сделать: интерфейс, синглтон
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final ClientService clientService = serviceProvider.getClientService();


    public Client creationUser(String request) {
        Client client = null;
        String[] params = request.split(" ");
        String login = " ";

        for (String param : params) {
            if (param.contains("login")) {//не верно
                login = param;
            }
        }
        try {
            //System.out.println(login+ "!!!!");
            client = clientService.userCreation(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return client;
    }
}
