package ru.maltseva.home_library.controller;

public class ControllerProvider {

    private final Controller controller;
    private static final ControllerProvider instance = new ControllerProvider();

    private ControllerProvider() {
        controller = new CommandController();
    }

    public static ControllerProvider getInstance() {
        return instance;
    }

    public Controller getController() {
        return controller;
    }
}
