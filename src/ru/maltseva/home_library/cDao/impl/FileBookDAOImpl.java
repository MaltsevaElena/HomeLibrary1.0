package ru.maltseva.home_library.cDao.impl;

import ru.maltseva.home_library.cDao.BookDAO;
import ru.maltseva.home_library.cDao.DAOException;
import ru.maltseva.home_library.entity.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileBookDAOImpl implements BookDAO {

    private static final String BOOKS_SOURCE = "C:\\Документы и фото\\Обучение Java\\IdeaProjects\\Java15\\modul6\\" +
            "modul6\\source\\BookCatalog.txt";


    public List<String> searchBook(String request) throws DAOException {

        List<String> allBooks;
        List<String> searchBook;

        Pattern pattern;
        Matcher matcher;

        searchBook = new ArrayList<>();
        pattern = Pattern.compile(request);

        allBooks = readFileBook();

        for (String book : allBooks) {
            matcher = pattern.matcher(book);
            while (matcher.find()) {
                searchBook.add(book);
            }
        }
        return searchBook;
    }

    @Override
    public boolean addBook(Book book) {

        /*
        открыть файл
        высчитать айди
        сформировать строчку из бук
        записать строчку в файл
        если все ок вернуть тру
         */
        return false;
    }


    @Override
    public List<String> readFileBook() throws DAOException {
        List<String> listBook = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKS_SOURCE))) {
            String line;
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    listBook.add(line);
                }
            }
            while (line != null);

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return listBook;
    }
}