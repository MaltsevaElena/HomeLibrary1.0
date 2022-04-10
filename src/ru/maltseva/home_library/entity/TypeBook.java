package ru.maltseva.home_library.entity;

public enum TypeBook {

    PAPER_BOOK ("Бумажная книга"), EBOOK ("Электронная книга");

    String name;
    TypeBook (String name){
        this.name = name;
    }

       public String getName() {
        return name;
    }
}
