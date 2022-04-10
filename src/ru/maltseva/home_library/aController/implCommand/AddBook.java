package ru.maltseva.home_library.aController.implCommand;

import ru.maltseva.home_library.aController.Command;
import ru.maltseva.home_library.bService.BookService;
import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;
import ru.maltseva.home_library.entity.Role;

public class AddBook implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    @Override
    public boolean execute(String request) {// сделать адаптер и добавить роль и книгу
        BookService bookService;
        ClientService clientService;
        String bookLine;

        boolean response = false;
        Role role = Role.ADMIN;

        bookService = serviceProvider.getBookService();
        clientService = serviceProvider.getClientService();

        bookLine = request.split(" - ", 2)[1];
        try {
            if (role.equals(Role.ADMIN)) {


                response = bookService.addBook(bookLine);
                if (response) {
                    System.out.println("Book successfully added.");
                }

            } else if (role.equals(Role.USER)) {

                response = clientService.sendEmail("role=Admin", bookLine);
                if (response) {
                    System.out.println("The book was sent to the administrator by e-mail.");
                }
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return response;
    }
}