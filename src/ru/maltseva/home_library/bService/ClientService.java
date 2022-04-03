package ru.maltseva.home_library.bService;

import ru.maltseva.home_library.entity.Client;

import java.util.List;

public interface ClientService {

    boolean verificationParam(String... param) throws ServiceException;

    boolean registration(String request) throws ServiceException;

    Client clientCreation(String login) throws ServiceException;

    List<String> sendEmail(String allEmail) throws ServiceException;
}
