package ru.maltseva.home_library.entity;

import java.io.Serializable;

public class User extends Client implements Serializable {

    private Role userRole = Role.USER;

    public User() {
    }

    public User(String name, String e_mail, String login, String password) {
        super(name, e_mail, login, password);
    }

    public Role getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userRole=" + userRole +
                '}';
    }
}
