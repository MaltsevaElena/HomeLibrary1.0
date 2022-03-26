package ru.maltseva.home_library.view.impl;

import ru.maltseva.home_library.entity.Book;
import ru.maltseva.home_library.view.ShowBook;

import java.util.List;

public class ShowAllBook implements ShowBook {
    @Override
    public void showBook(List<Book> allBook) {
        for (Book book :allBook) {
            System.out.println("Номер (id) книги: "+book.getId());
            System.out.println("Название: "+book.getName()+", автор: "+ book.getAuthor()+
                    ", год издания: "+book.getYear()+", тип книги: "+book.getTypeBook().toString());
            System.out.println("Описание: "+book.getDescription());
            System.out.println();
        }
    }
}