package ru.maltseva.home_library.view;

import ru.maltseva.home_library.view.impl.*;

public class ViewProvider {
    private final AnswerForUser answerForUser;
    private final MenuSingIn menuSingIn;
    private final MenuBook menuBook;
    private final ShowBook showBook;
    private final AnswerToActionOnBook answerToActionOnBook;

    private static ViewProvider instance = new ViewProvider();

    private ViewProvider(){

        answerForUser = new AnswerForUserImpl();
        menuSingIn = new MenuSingInImp();
        menuBook = new MenuBookImp();
        showBook = new ShowAllBook();
        answerToActionOnBook = new AnswerDeleteBookImpl();// сделать map
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
}
