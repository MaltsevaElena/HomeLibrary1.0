package ru.maltseva.home_library.bService;

import ru.maltseva.home_library.entity.Client;

public interface ClientService {

    boolean registration(String request) throws ServiceException;
     boolean verificationParam(String ... param) throws ServiceException;

    Client userCreation (String login) throws ServiceException;
}
