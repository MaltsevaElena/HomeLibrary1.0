package ru.maltseva.home_library.view;

import ru.maltseva.home_library.view.impl.AnswerForUserImpl;
import ru.maltseva.home_library.view.impl.MenuBookImp;
import ru.maltseva.home_library.view.impl.MenuSingInImp;

public class ViewProvider {
    private final AnswerForUser answerForUser;
    private final MenuSingIn menuSingIn;
    private final MenuBook menuBook;

    private static ViewProvider instance = new ViewProvider();

    private ViewProvider(){

        answerForUser = new AnswerForUserImpl();
        menuSingIn = new MenuSingInImp();
        menuBook = new MenuBookImp();
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
}
