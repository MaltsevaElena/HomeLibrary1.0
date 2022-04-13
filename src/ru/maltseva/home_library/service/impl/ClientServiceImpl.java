package ru.maltseva.home_library.service.impl;

import ru.maltseva.home_library.service.ClientService;
import ru.maltseva.home_library.service.ServiceException;
import ru.maltseva.home_library.dao.ClientDAO;
import ru.maltseva.home_library.dao.DAOException;
import ru.maltseva.home_library.dao.DAOProvider;
import ru.maltseva.home_library.entity.Administrator;
import ru.maltseva.home_library.entity.User;
import ru.maltseva.home_library.view.AnswerSendEmail;
import ru.maltseva.home_library.view.ViewProvider;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final DAOProvider provider = DAOProvider.getInstance();
    private final ViewProvider viewProvider = ViewProvider.getInstance();

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
        AnswerSendEmail answerSendEmail;
        boolean result;

        clientDAO = provider.getClientDAO();
        answerSendEmail = viewProvider.getAnswerSendEmail();
        try {
            emails = clientDAO.email(roleUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        result = emails.size() > 0;
        answerSendEmail.answer(result);

        if (result) {
            System.out.println(message);
            for (String email : emails) {
                System.out.println(email);
            }
        }
        return result;
    }
}
