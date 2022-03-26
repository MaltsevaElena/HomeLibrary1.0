package ru.maltseva.home_library.entity;

public class Client {

    private String name;
    private String e_mail;
    private String login;
    private String password;
    private Role userRole;


    public Client() {
    }

    public Client(String name, String e_mail, String login, String password, Role userRole) {
        this.name = name;
        this.e_mail = e_mail;
        this.login = login;
        this.password = password;
        this.userRole = userRole;

    }


}
