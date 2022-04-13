package ru.maltseva.home_library.controller.implCommand;

import ru.maltseva.home_library.controller.Command;
import ru.maltseva.home_library.service.BookService;
import ru.maltseva.home_library.service.ClientService;
import ru.maltseva.home_library.service.ServiceException;
import ru.maltseva.home_library.service.ServiceProvider;
import ru.maltseva.home_library.entity.Role;
import ru.maltseva.home_library.view.AnswerAddBook;
import ru.maltseva.home_library.view.ViewProvider;

public class AddBook implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final ViewProvider viewProvider = ViewProvider.getInstance();

    @Override
    public boolean execute(String request) {
        BookService bookService;
        ClientService clientService;
        Role roleAdmin;
        Role roleUser;
        String bookLine;
        String roleString;
        AnswerAddBook viewAnswer;

        boolean response = false;

        bookService = serviceProvider.getBookService();
        clientService = serviceProvider.getClientService();
        viewAnswer = viewProvider.getAnswerAddBook();

        bookLine = request.split(" - ", 2)[1];
        roleString = request.split(" - ")[6];
        roleAdmin = Role.ADMIN;
        roleUser = Role.USER;

        try {
            if (roleAdmin.getName().equalsIgnoreCase(roleString)) {

                response = bookService.addBook(bookLine);
                viewAnswer.answer(response);

            } else if (roleUser.getName().equalsIgnoreCase(roleString)) {

                response = clientService.sendEmail("role=Admin", bookLine);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return response;
    }
}