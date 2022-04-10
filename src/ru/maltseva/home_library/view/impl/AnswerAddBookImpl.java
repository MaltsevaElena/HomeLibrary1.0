package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.view.AnswerAddBook;

public class AnswerAddBookImpl implements AnswerAddBook {
    @Override
    public void answer(boolean result) {
        if (result) {
            System.out.println("Book successfully added.");
        } else {
            System.out.println("Book not added.");
        }
    }
}
