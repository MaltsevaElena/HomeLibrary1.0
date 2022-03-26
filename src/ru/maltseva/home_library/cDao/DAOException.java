package ru.maltseva.home_library.cDao;

import java.io.Serial;

public class DAOException extends Exception {

    @Serial
    private static final long serialVersionUID = 1357721243278634694L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}
