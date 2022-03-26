package ru.maltseva.home_library.view;

import ru.maltseva.home_library.view.impl.AnswerForUserImpl;

public class ViewProvider {
    private final AnswerForUser answerForUser;

    private static ViewProvider instance = new ViewProvider();

    private ViewProvider(){
        answerForUser = new AnswerForUserImpl();
    }

    public static ViewProvider getInstance(){
        return instance;
    }

    public AnswerForUser getUserActionView() {
        return answerForUser;
    }
}
