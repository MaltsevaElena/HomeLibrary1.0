package ru.maltseva.home_library.entity;

public class User extends Client{

    public User(String name, String e_mail, String login, String password, Role userRole) {
        super(name, e_mail, login, password, userRole);
    }
}
