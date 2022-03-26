package ru.maltseva.home_library.bService;

import ru.maltseva.home_library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> searchBook(String request) throws ServiceException;
    boolean addBook(Book book);
    List<Book> ViewingBooks() throws ServiceException;

}
