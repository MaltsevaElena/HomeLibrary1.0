package ru.maltseva.home_library.view;

import ru.maltseva.home_library.view.impl.*;

public class ViewProvider {
    private final AnswerForUser answerForUser;
    private final MenuSingIn menuSingIn;
    private final MenuBook menuBook;
    private final ShowBook showBook;
    private final AnswerAddBook answerAddBook;
    private final AnswerSendEmail answerSendEmail;
    private final AnswerDeleteBook answerDeleteBook;

    private static ViewProvider instance = new ViewProvider();

    private ViewProvider(){

        answerForUser = new AnswerForUserImpl();
        menuSingIn = new MenuSingInImp();
        menuBook = new MenuBookImp();
        showBook = new ShowAllBook();
        answerAddBook = new AnswerAddBookImpl();
        answerSendEmail = new AnswerSendEmailImpl();
        answerDeleteBook = new AnswerDeleteBookImpl();
    }

    public static ViewProvider getInstance(){
        return instance;
    }

    public AnswerForUser getAnswerForUser() {
        return answerForUser;
    }

    public MenuSingIn getMenuSingIn() {
        return menuSingIn;
    }

    public MenuBook getMenuBook() {
        return menuBook;
    }

    public ShowBook getShowBook() {
        return showBook;
    }

    public AnswerAddBook getAnswerAddBook() {
        return answerAddBook;
    }

    public AnswerSendEmail getAnswerSendEmail() {
        return answerSendEmail;
    }

    public AnswerDeleteBook getAnswerDeleteBook() {
        return answerDeleteBook;
    }
}
