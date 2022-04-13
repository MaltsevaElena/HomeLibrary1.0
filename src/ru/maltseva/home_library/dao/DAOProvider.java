package ru.maltseva.home_library.dao;

import ru.maltseva.home_library.dao.impl.FileBookDAOImpl;
import ru.maltseva.home_library.dao.impl.FileClientDAOImpl;

public final class DAOProvider {

    private final ClientDAO clientDAO;
    private final BookDAO bookDAO;
    private static final DAOProvider instance = new DAOProvider();

    private DAOProvider() {
        clientDAO = new FileClientDAOImpl();
        bookDAO = new FileBookDAOImpl();
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }
}
