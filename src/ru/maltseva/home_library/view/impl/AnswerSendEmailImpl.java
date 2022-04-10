package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.AnswerSendEmail;

public class AnswerSendEmailImpl implements AnswerSendEmail {

    @Override
    public void answer(boolean result) {

        if (result) {
            System.out.println("The book was sent to the administrator by e-mail.");
        }
        else {
            System.out.println("The letter not sent.");
        }
    }
}