package ru.maltseva.home_library.cDao.impl;

import ru.maltseva.home_library.cDao.ClientDAO;
import ru.maltseva.home_library.cDao.DAOException;

import java.io.*;

public class FileClientDAOImpl implements ClientDAO {
    private static final String CLIENT_SOURCE = "C:\\ForJava\\HomeLibrary1.0\\src\\ru\\maltseva\\home_library\\source" +
            "\\AuthenticationData.txt";

    @Override
    public boolean verificationParam(String... param) throws DAOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENT_SOURCE))) {
            String line;
            String[] dataBaseLine;

            int count = 0;

            while ((line = reader.readLine()) != null) {
                dataBaseLine = line.split(" - ");
                for (String dataLine : dataBaseLine) {
                    for (String paramLine : param) {
                        if (paramLine.equals(dataLine)) {
                            count++;
                        }
                    }
                }
                if (count == param.length) {
                    return true;
                } else {
                    count = 0;
                }
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return false;
    }


    @Override
    public boolean saveUser(String request) throws DAOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLIENT_SOURCE, true))) {
            writer.write(request);
            writer.append("\n");

        } catch (IOException e) {
            throw new DAOException(e);
        }

        return true;//в каком случае вернется фолс?
    }

    @Override
    public String gettingClient(String login) throws DAOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENT_SOURCE))) {
            String line;
            String[] dataBaseLine;
            while ((line = reader.readLine()) != null) {
                dataBaseLine = line.split(" - ");
                for (String dataLine : dataBaseLine ){
                    if (dataLine.equals(login)) {
                        return line;
                    }
                }
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return "Пользователь не найден.";
    }

}
