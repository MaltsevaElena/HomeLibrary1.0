package ru.maltseva.home_library.cDao;

import ru.maltseva.home_library.cDao.impl.FileBookDAOImpl;
import ru.maltseva.home_library.cDao.impl.FileClientDAOImpl;

public final class DAOProvider {

    private final ClientDAO clientDAO;
    private final BookDAO bookDAO;
    private static DAOProvider instance = new DAOProvider();

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
