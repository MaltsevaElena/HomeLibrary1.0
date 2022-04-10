package ru.maltseva.home_library.aController.implCommand;

import ru.maltseva.home_library.aController.Command;
import ru.maltseva.home_library.bService.BookService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.view.AnswerDeleteBook;
import ru.maltseva.home_library.view.ViewProvider;


public class DeleteBook implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        BookService bookService;
        AnswerDeleteBook answerDeleteBook;
        int bookId;
        boolean response = false;

        bookService = serviceProvider.getBookService();
        answerDeleteBook = viewProvider.getAnswerDeleteBook();

        try {
            bookId = Integer.parseInt(request.split(" - ")[1].split("=")[1]);
            response = bookService.deleteBook(bookId);
            answerDeleteBook.answer(response);

        } catch (ServiceException serviceException) {
            serviceException.printStackTrace();
        }
        return response;
    }
}