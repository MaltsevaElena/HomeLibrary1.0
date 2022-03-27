package ru.maltseva.home_library.entity;

import java.io.Serializable;

public class Client implements Serializable {

    private String name;
    private String e_mail;
    private String login;
    private String password;

    public Client() {
    }

    public Client(String name, String e_mail, String login, String password) {
        this.name = name;
        this.e_mail = e_mail;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
