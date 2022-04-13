package ru.maltseva.home_library.dao.impl;

import ru.maltseva.home_library.dao.BookDAO;
import ru.maltseva.home_library.dao.DAOException;
import ru.maltseva.home_library.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileBookDAOImpl implements BookDAO {

    private static final String BOOKS_SOURCE = "C:\\ForJava\\HomeLibrary1.0\\src\\ru\\maltseva\\" +
            "home_library\\source\\BookCatalog.txt";

    @Override
    public boolean addBook(Book book) throws DAOException {
        int size;
        int maxId;

        List<String> allBook;
        StringBuilder stringBook;

        allBook = getAllBook();
        size = allBook.size();

        if (size == 0) {
            maxId = 1;
        } else {
            try {
                maxId = Integer.parseInt(allBook.get(size - 1).split(" - ")[0].split("=")[1]) + 1;
                //берем последнюю книгу, определяем ее id прибавляем 1
            } catch (NumberFormatException e) {
                throw new DAOException(e);
            }
        }
        stringBook = new StringBuilder();
        stringBook.append("id=").append(maxId).append(" - name=").append(book.getName())
                .append(" - author=").append(book.getAuthor()).append(" - year=")
                .append(book.getYear()).append(" - typeBook=").append(book.getTypeBook())
                .append(" - description=").append(book.getDescription());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_SOURCE, true))) {
            writer.write(String.valueOf(stringBook));
            writer.append("\n");

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return true;
    }

    @Override
    public List<String> getAllBook() throws DAOException {
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

    @Override
    public boolean changeBook(int idBook, String parameter) throws DAOException {
        List<String> listBook = getAllBook();
        int id;
        String[] parameterBook;
        String nameParameter;
        StringBuilder changeBook = new StringBuilder();

        nameParameter = parameter.split("=")[0];
        try {
            new FileWriter(BOOKS_SOURCE, false).close();
        } catch (IOException e) {
            throw new DAOException(e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_SOURCE, true))) {

            for (int i = 0; i < listBook.size(); i++) {
                id = Integer.parseInt(listBook.get(i).split(" - ")[0].split("=")[1]);
                if (id == idBook) {
                    parameterBook = listBook.get(i).split(" - ");
                    for (int j = 0; j < parameterBook.length; j++) {
                        if (parameterBook[j].contains(nameParameter)) {
                            parameterBook[j] = parameter;
                        }
                    }
                    for  (int k = 0; k < parameterBook.length; k++) {
                        changeBook.append(parameterBook[k]);
                        if (k!= parameterBook.length-1){
                            changeBook.append(" - ");
                        }
                    }
                    listBook.set(i, changeBook.toString());
                }
                writer.write(listBook.get(i));
                writer.append("\n");
            }
        } catch (NumberFormatException | IOException e) {
            throw new DAOException(e);
        }

        return true;
    }

    @Override
    public boolean deleteBook(int idBook) throws DAOException {
        List<String> listBook = getAllBook();
        int listSize = listBook.size();
        int id;

        try {
            new FileWriter(BOOKS_SOURCE, false).close();
        } catch (IOException e) {
            throw new DAOException(e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_SOURCE, true))) {

            for (int i = 0; i < listBook.size(); i++) {
                id = Integer.parseInt(listBook.get(i).split(" - ")[0].split("=")[1]);
                if (id == idBook) {
                    listBook.remove(i);

                }
                writer.write(listBook.get(i));
                writer.append("\n");
            }
        } catch (NumberFormatException | IOException e) {
            throw new DAOException(e);
        }

        return !(listSize ==listBook.size());
    }
}