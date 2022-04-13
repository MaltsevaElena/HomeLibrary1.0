package ru.maltseva.home_library.entity;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private static int count;
    private int id;
    private String name;
    private String author;
    private int year;
    private TypeBook typeBook;
    private String description;

    public Book() {
        this.id = count++;
    }

    public Book(String name, String author, int year, TypeBook typeBook) {
        this.id = count++;
        this.name = name;
        this.author = author;
        this.year = year;
        this.typeBook = typeBook;
    }

    public Book(String name, String author, int year, TypeBook typeBook, String description) {
        this.id = count++;
        this.name = name;
        this.author = author;
        this.year = year;
        this.typeBook = typeBook;
        this.description = description;
    }
    public Book(int id, String name, String author, int year, TypeBook typeBook, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.typeBook = typeBook;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public TypeBook getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(TypeBook typeBook) {
        this.typeBook = typeBook;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (!Objects.equals(name, book.name)) return false;
        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(typeBook, book.typeBook)) return false;
        return Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (typeBook != null ? typeBook.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{ id=" + id +", name='" + name + '\'' +
                ", author='" + author + '\'' + ", year=" + year +
                ", typeBook='" + typeBook + '\'' + ", description='" + description + '\'' +
                '}';
    }
}
