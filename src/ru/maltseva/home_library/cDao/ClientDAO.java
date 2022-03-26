package ru.maltseva.home_library.cDao;


public interface ClientDAO {


    boolean verificationParam(String ... param) throws DAOException; //готово

    boolean saveUser(String request) throws DAOException; //готово

    String userCreation (String login) throws DAOException;
}
