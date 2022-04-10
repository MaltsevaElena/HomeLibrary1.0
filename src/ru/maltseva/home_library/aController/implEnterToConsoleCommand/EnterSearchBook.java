package ru.maltseva.home_library.aController.implEnterToConsoleCommand;

import ru.maltseva.home_library.aController.EnterToConsoleCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterSearchBook implements EnterToConsoleCommand {

    @Override
    public StringBuffer enterData() {
        StringBuffer response;
        String validationLine;

        response = new StringBuffer("SearchBook - ");

        @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Критерий для поиска книги:");
        System.out.println("-> ");

        try {
            validationLine = reader.readLine();
            response.append(validationLine);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}