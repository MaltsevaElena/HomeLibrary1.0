package ru.maltseva.home_library.service;

import ru.maltseva.home_library.entity.User;

public interface ClientService {

    boolean verificationParam(String... param) throws ServiceException;

    boolean registration(String request) throws ServiceException;

    User clientCreation(String login) throws ServiceException;

    boolean sendEmail(String allEmail, String book) throws ServiceException;
}
