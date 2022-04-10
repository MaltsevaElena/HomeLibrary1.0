package ru.maltseva.home_library.aController.implCommand;

import ru.maltseva.home_library.aController.Command;
import ru.maltseva.home_library.bService.BookService;
import ru.maltseva.home_library.bService.ClientService;
import ru.maltseva.home_library.bService.ServiceException;
import ru.maltseva.home_library.bService.ServiceProvider;


public class EditingBook implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();

    @Override
    public boolean execute(String request) {
        BookService bookService;
        ClientService clientService;
        String bookParam;
        String strId;
        String message;
        int id;


        boolean response = false;

        bookService = serviceProvider.getBookService();
        clientService = serviceProvider.getClientService();

        strId = request.split(" - ")[1];
        id = Integer.parseInt(strId.split("=")[1]);
        bookParam = request.split(" - ")[2];

        message = "Изменена книга с "+strId +". Сообщение отправлено на электронные адреса: ";

        try {
            response = bookService.editBook(id, bookParam);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (response) {
            try {
                response = clientService.sendEmail("All", message);

            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}
