package ru.maltseva.home_library.bService;

import ru.maltseva.home_library.entity.Client;

public interface ClientService {

    boolean verificationParam(String ... param) throws ServiceException;

    boolean registration(String request) throws ServiceException;

    Client clientCreation (String login) throws ServiceException;
}
