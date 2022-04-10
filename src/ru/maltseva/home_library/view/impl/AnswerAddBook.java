package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.AnswerToActionOnBook;

public class AnswerAddBook implements AnswerToActionOnBook {
    @Override
    public void answerToActionOnBook(boolean result) {
        if (result) {
            System.out.println("Book successfully added.");
        } else {
            System.out.println("Book not added.");
        }
    }
}
