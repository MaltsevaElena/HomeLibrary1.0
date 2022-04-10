package ru.maltseva.home_library.bService.impl;

import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.cDao.ClientDAO;
import ru.maltseva.home_library.cDao.DAOException;
import ru.maltseva.home_library.cDao.DAOProvider;
import ru.maltseva.home_library.entity.Administrator;
import ru.maltseva.home_library.entity.Book;
import ru.maltseva.home_library.entity.User;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public boolean verificationParam(String... param) throws ServiceException {
        ClientDAO clientDAO;
        boolean result;

        clientDAO = provider.getClientDAO();

        try {
            result = clientDAO.verificationParam(param);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean registration(String request) throws ServiceException {
        ClientDAO clientDAO;
        String registrationInfo;
        boolean result;

        clientDAO = provider.getClientDAO();
        registrationInfo = request.split(" - ", 2)[1];
        try {
            result = clientDAO.saveUser(registrationInfo);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return result;
    }

    @Override
    public User clientCreation(String login) throws ServiceException {
        User user;

        String line;
        String[] params;
        ClientDAO clientDAO;


        clientDAO = provider.getClientDAO();
        try {
            line = clientDAO.gettingClient(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        params = line.split(" - ");


        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].split("=")[1];
        }

        if (params[4].equals("Admin")) {
            user = new Administrator(params[0], params[1], params[2], params[3]);
        } else {
            user = new User(params[0], params[1], params[2], params[3]);
        }

        return user;
    }

    @Override
    public boolean sendEmail(String roleUser, String message) throws ServiceException {
        ClientDAO clientDAO;
        List<String> emails;

        clientDAO = provider.getClientDAO();
        try {
            emails = clientDAO.email(roleUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        System.out.println(message);

        for (String email : emails) {
            System.out.println(email);
        }

        return emails.size()>0;
    }
}
