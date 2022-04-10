package ru.maltseva.home_library.entity;

public class Administrator extends User{

    private final Role userRole = Role.ADMIN;

    public Administrator() {
    }

    public Administrator(String name, String e_mail, String login, String password) {
        super(name, e_mail, login, password);
    }

    public Role getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "Administrator{ name=" + super.getName() +", e_mail=" + super.getE_mail()+", login="+ super.getLogin()+
                ", password=" + super.getPassword()+ ", userRole=" + userRole +
                '}';
    }
}
