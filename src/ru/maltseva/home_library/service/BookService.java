package ru.maltseva.home_library.service;

import ru.maltseva.home_library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> viewingBooks() throws ServiceException;

    List<Book> searchBook(String request) throws ServiceException;

    boolean addBook(String book) throws ServiceException;

    boolean editBook(int idBook, String parameter) throws ServiceException;

    boolean deleteBook(int idBook) throws ServiceException;






}
