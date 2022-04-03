package ru.maltseva.home_library.bService;

import ru.maltseva.home_library.bService.impl.BookServiceImpl;
import ru.maltseva.home_library.bService.impl.ClientServiceImpl;

public class ServiceProvider {

    private final ClientService clientService;
    private final BookService bookService;

    private static ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {
        clientService = new ClientServiceImpl();
        bookService = new BookServiceImpl();
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public  BookService getBookService(){
        return bookService;
    }
}
