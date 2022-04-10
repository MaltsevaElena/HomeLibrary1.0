package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.AnswerDeleteBook;

public class AnswerDeleteBookImpl implements AnswerDeleteBook {
    @Override
    public void answer(boolean result) {
        if (result) {
            System.out.println("Book successfully delete.");
        } else {
            System.out.println("No book found with this id.");
        }
    }
}
