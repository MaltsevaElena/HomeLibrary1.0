package ru.maltseva.home_library.cDao;

import ru.maltseva.home_library.entity.Book;

import java.util.List;

public interface BookDAO {

    boolean addBook(Book book)throws DAOException;
    List<String> readFileBook() throws DAOException;

}
