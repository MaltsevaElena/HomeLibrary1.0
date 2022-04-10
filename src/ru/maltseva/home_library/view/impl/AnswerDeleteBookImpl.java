package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.AnswerToActionOnBook;

public class AnswerDeleteBookImpl implements AnswerToActionOnBook {
    @Override
    public void answerToActionOnBook(boolean result) {
        if (result) {
            System.out.println("Book successfully delete.");
        }
        else {
            System.out.println("No book found with this id.");
        }
    }
}
