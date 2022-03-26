package ru.maltseva.home_library.entity;

public class Administrator extends Client{

    public Administrator(String name, String e_mail, String login, String password, Role userRole) {
        super(name, e_mail, login, password, userRole);
    }
}
