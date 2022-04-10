package ru.maltseva.home_library.view.impl;


import ru.maltseva.home_library.view.AnswerToActionOnBook;

public class AnswerSendEmail implements AnswerToActionOnBook {
    @Override
    public void answerToActionOnBook(boolean result) {

        if (result) {
            System.out.println("The book was sent to the administrator by e-mail.");
        }
        else {
            System.out.println("The letter not sent.");
        }

    }
}