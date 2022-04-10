package ru.maltseva.home_library.aController.implCommand;

import ru.maltseva.home_library.aController.Command;
import ru.maltseva.home_library.bService.BookService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.entity.Book;
import ru.maltseva.home_library.view.ShowBook;
import ru.maltseva.home_library.view.ViewProvider;

import java.util.List;

public class SearchBook implements Command {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        BookService bookService;
        List<Book> searchListBook = null;
        ShowBook viewBook;
        String searchWord;

        bookService = serviceProvider.getBookService();
        searchWord = request.split(" - ")[1];

        try {
            searchListBook = bookService.searchBook(searchWord);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        viewBook = viewProvider.getShowBook();
        viewBook.showBook(searchListBook);

        return (searchListBook != null ? searchListBook.size() : 0) >0;
    }
}