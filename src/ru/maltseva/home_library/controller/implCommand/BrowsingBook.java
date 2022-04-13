package ru.maltseva.home_library.controller.implCommand;

import ru.maltseva.home_library.controller.Command;
import ru.maltseva.home_library.service.BookService;
import ru.maltseva.home_library.service.ServiceException;
import ru.maltseva.home_library.service.ServiceProvider;
import ru.maltseva.home_library.entity.Book;
import ru.maltseva.home_library.view.ShowBook;
import ru.maltseva.home_library.view.ViewProvider;

import java.util.List;

public class BrowsingBook implements Command {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        BookService bookService;
        List<Book> allBook = null;
        ShowBook showBook;

        bookService = serviceProvider.getBookService();
        try {
            allBook = bookService.viewingBooks();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        showBook = viewProvider.getShowBook();
        showBook.showBook(allBook);

        return (allBook != null ? allBook.size() : 0) >0;
    }
}
