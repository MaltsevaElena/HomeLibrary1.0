package ru.maltseva.home_library.aController.implCommand;

import ru.maltseva.home_library.aController.Command;
import ru.maltseva.home_library.bService.BookService;
import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.entity.Role;
import ru.maltseva.home_library.view.AnswerAddBook;
import ru.maltseva.home_library.view.AnswerSendEmail;
import ru.maltseva.home_library.view.ViewProvider;

public class AddBook implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        BookService bookService;
        ClientService clientService;
        String bookLine;
        AnswerAddBook viewAnswer;
        AnswerSendEmail answerSendEmail;

        boolean response = false;
        Role role = Role.ADMIN;

        bookService = serviceProvider.getBookService();
        clientService = serviceProvider.getClientService();
        viewAnswer = viewProvider.getAnswerAddBook();
        answerSendEmail = viewProvider.getAnswerSendEmail();

        bookLine = request.split(" - ", 2)[1];
        try {
            if (role.equals(Role.ADMIN)) {


                response = bookService.addBook(bookLine);
                viewAnswer.answer(response);

            } else if (role.equals(Role.USER)) {

                response = clientService.sendEmail("role=Admin", bookLine);
                answerSendEmail.answer(response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return response;
    }
}