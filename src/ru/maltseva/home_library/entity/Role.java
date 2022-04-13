package ru.maltseva.home_library.entity;

public enum Role {
    ADMIN ("Admin"), USER ("User");

    String name;
    Role (String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

