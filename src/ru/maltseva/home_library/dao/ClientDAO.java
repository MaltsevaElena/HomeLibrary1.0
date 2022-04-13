package ru.maltseva.home_library.dao;


import java.util.List;

public interface ClientDAO {


    boolean verificationParam(String ... param) throws DAOException;

    boolean saveUser(String request) throws DAOException;

    String gettingClient (String login) throws DAOException;

    List <String> email (String roleUser) throws DAOException;
}

