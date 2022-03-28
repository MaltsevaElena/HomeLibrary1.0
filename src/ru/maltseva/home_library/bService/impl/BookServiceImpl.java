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
import java.util.regex.Pattern;

public class BookServiceImpl implements BookService {

    private final DAOProvider provider = DAOProvider.getInstance();
    private final BookDAO bookDAO = provider.getBookDAO();

    @Override
    public List<Book> searchBook(String request) throws ServiceException {
        //id=123
        //Author=Дмитрий
        List <String> bookList; // книги в виде строк
        String line1;
        String line2;

        try {
            bookList = bookDAO.getAllBook();
        } catch (DAOException e) {
           throw new ServiceException(e);
        }

        line1 = request.split("=")[0];
        line2 = request.split("=")[1];

        Pattern pattern = Pattern.compile("");
        //“A.+a”// Ищет максимальное по длине совпадение в строке.
        // Строчка которая придет разделить через =
        return null;
    }


    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public List<Book> ViewingBooks() throws ServiceException {
        List<String> bookCatalog;
        List<Book> allBook = new ArrayList<>();
        String[] array;
        int id;
        int year;
        TypeBook typeBook;
        Book book;

        try {
            // считывает из файла строки с книгами
            bookCatalog = bookDAO.getAllBook();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        // На основании полученных строк создаем коллекцию книг
        for (String s : bookCatalog) {
            array = s.split(" ", 6); //6 полей у класса BOOK
            try {
                id = Integer.parseInt(array[0]);
                year = Integer.parseInt(array[3]);
            } catch (NumberFormatException e) {
                throw new ServiceException(e);
            }

            if (array[4].equals("Бумажная_книга")) {
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
