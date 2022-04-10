package ru.maltseva.home_library.aController.implCommand;

import ru.maltseva.home_library.aController.Command;
import ru.maltseva.home_library.bService.BookService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;


public class DeleteBook implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    @Override
    public boolean execute(String request) {
        BookService bookService;
        int bookId;
        boolean response = false;

        bookService = serviceProvider.getBookService();

        try {
            bookId = Integer.parseInt(request.split(" - ")[1].split("=")[1]);
            response = bookService.deleteBook(bookId);
                if (response) {
                    System.out.println("Book successfully delete.");
                }
                else {
                    System.out.println("No book found with this id.");
                }
            } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }
        return response;
    }
}