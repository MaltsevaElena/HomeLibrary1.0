package ru.maltseva.home_library.dao;

import ru.maltseva.home_library.entity.Book;

import java.util.List;

public interface BookDAO {

    boolean addBook(Book book) throws DAOException;

    List<String> getAllBook() throws DAOException;

    boolean changeBook (int idBook, String parameter) throws DAOException;

    boolean deleteBook (int idBook) throws DAOException;

}
