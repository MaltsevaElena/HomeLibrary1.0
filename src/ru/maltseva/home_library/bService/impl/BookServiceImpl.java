package ru.maltseva.home_library.bService.impl;

import ru.maltseva.home_library.bService.BookService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.cDao.BookDAO;
import ru.maltseva.home_library.cDao.DAOException;
import ru.maltseva.home_library.cDao.DAOProvider;
import ru.maltseva.home_library.entity.Book;
import ru.maltseva.home_library.entity.TypeBook;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public List<Book> viewingBooks() throws ServiceException {
        List<String> bookCatalog;
        List<Book> allBook;
        BookDAO bookDAO;

        bookDAO = provider.getBookDAO();
        try {
            bookCatalog = bookDAO.getAllBook();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        allBook = createBook(bookCatalog);
        return allBook;
    }

    @Override
    public List<Book> searchBook(String request) throws ServiceException {
        List<String> allBookList;
        List<Book> searchBook;
        BookDAO bookDAO;

        bookDAO = provider.getBookDAO();
        try {
            allBookList = bookDAO.getAllBook();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (int i = 0; i < allBookList.size(); i++) {
            if (!allBookList.get(i).contains(request)) {
                allBookList.remove(i);
                --i;
            }
        }
        searchBook = createBook(allBookList);

        return searchBook;
    }

    @Override
    public boolean addBook(String bookLine) throws ServiceException {
        boolean result;
        BookDAO bookDAO;
        Book book;
        String[] bookParameter;
        int year;
        TypeBook typeBook;

        bookDAO = provider.getBookDAO();
        bookParameter = bookLine.split(" - ");

        for (int i = 0; i < bookParameter.length; i++) {
            bookParameter[i] = bookParameter[i].split("=")[1];
        }
        year = Integer.parseInt(bookParameter[2]);
        if (bookParameter[3].equalsIgnoreCase(TypeBook.PAPER_BOOK.getName())) {
            typeBook = TypeBook.PAPER_BOOK;
        } else {
            typeBook = TypeBook.EBOOK;
        }

        book = new Book(bookParameter[0], bookParameter[1], year, typeBook, bookParameter[4]);

        try {
            result = bookDAO.addBook(book);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean editBook(int idBook, String parameter) throws ServiceException {
        boolean result;
        BookDAO bookDAO;

        bookDAO = provider.getBookDAO();

        try {
            result = bookDAO.changeBook(idBook, parameter);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean deleteBook(int idBook) throws ServiceException {
        boolean result;
        BookDAO bookDAO;

        bookDAO = provider.getBookDAO();

        try {
            result = bookDAO.deleteBook(idBook);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    public List<Book> createBook(List<String> allBookList) throws ServiceException {
        List<Book> allBook = new ArrayList<>();
        String[] array;
        int id;
        int year;
        TypeBook typeBook;
        Book book;

        for (String line : allBookList) {
            array = line.split(" - ");
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i].split("=")[1];
            }

            try {
                id = Integer.parseInt(array[0]);
                year = Integer.parseInt(array[3]);
            } catch (NumberFormatException e) {
                throw new ServiceException(e);
            }

            if (array[4].equals("PAPER_BOOK")) {
                typeBook = TypeBook.PAPER_BOOK;
            } else {
                typeBook = TypeBook.EBOOK;
            }

            book = new Book(id, array[1], array[2], year, typeBook, array[5]);
            allBook.add(book);
        }
        return allBook;

    }
}