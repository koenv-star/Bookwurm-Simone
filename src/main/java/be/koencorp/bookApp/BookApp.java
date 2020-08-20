package be.koencorp.bookApp;


import be.koencorp.bookApp.dao.BookJpaDao;
import be.koencorp.bookApp.tools.ConsoleInputTool;
import be.koencorp.bookApp.tools.ConsolePrintTool;

import javax.persistence.Persistence;


public class BookApp {

    private static BookJpaDao bookJpaDao;
    ConsoleInputTool consoleInput = new ConsoleInputTool();

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("bookpu");
        var em = emf.createEntityManager();
//        Book book01 = new Book("a", "b", "111111113", "22222", Type.ROMAN, true, null);
        bookJpaDao = new BookJpaDao(em);
//        bookJpaDao.create(book01);

        BookApp app = new BookApp();
        app.startMenu();

    }


//   public void fillDatabase() {
//        Book book_01 = new Book("Tiny gaat op reis", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_02 = new Book("Tiny krijgt een gasboete", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_03 = new Book("Tiny liet een windje in de tent", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_04 = new Book("Tiny doet kaka in de tuin", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_05 = new Book("Tiny is op vakantie", " Gilbert Delahaye", Status.UNASSIGNED);
//
//        dao.save(book_01);
//        dao.save(book_02);
//        dao.save(book_03);
//        dao.save(book_04);
//        dao.save(book_05);
//
//
//    }

    public void startMenu() {
        int choice;
        do {
            System.out.println("Hello " + ConsolePrintTool.ANSI_YELLOW + "Simone" + ConsolePrintTool.ANSI_RESET + "!" + " Hope you are having a good day! Welcome to the BookApp starting menu, " +
                    "please choose one of the following options: ");

            printMenu();

            choice = consoleInput.askUserPosIntBetweenRange("Input a number between 1 and 5", 1, 5);

            if (choice == 1) {

                bookJpaDao.findAllOrderByTitle().stream().forEach(System.out::println);

                ConsolePrintTool.printEnter();

            }

            if (choice == 2) {

            }
            if (choice == 3) {

                ConsolePrintTool.printEnter();
            }

            if (choice == 4) {

            }

        }
        while (choice != 5);
    }

    private void printMenu() {
        System.out.println("1. List all the books you want to read.");
        System.out.println("2. List all the books you have already read.");
        System.out.println("3. Add a book to the list.");
        System.out.println("4. Archive a book.");
        System.out.println("5. Exit the app.");
        ConsolePrintTool.printEnter();
    }
}
