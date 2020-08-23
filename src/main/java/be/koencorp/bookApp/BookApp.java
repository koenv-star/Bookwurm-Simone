package be.koencorp.bookApp;

import be.koencorp.bookApp.dao.BookJpaDao;
import be.koencorp.bookApp.model.Book;
import be.koencorp.bookApp.model.Type;
import be.koencorp.bookApp.tools.ConsoleInputTool;
import be.koencorp.bookApp.tools.ConsolePrintTool;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.Persistence;

public class BookApp {

  private BookJpaDao bookJpaDao;
  private ConsoleInputTool consoleInputTool;

  public BookApp(BookJpaDao bookJpaDao) {
    this.bookJpaDao = bookJpaDao;
    this.consoleInputTool = new ConsoleInputTool();
  }

  public static void main(String[] args) {
    var emf = Persistence.createEntityManagerFactory("bookpu");
    var em = emf.createEntityManager();

    var consoleInputTool = new ConsoleInputTool();
    var bookJpaDao = new BookJpaDao(em);

    new BookApp(bookJpaDao).startMenu();
  }

  public void startMenu() {
    int choice;
    do {
      System.out.println(
          "Hello " + ConsolePrintTool.ANSI_YELLOW + "Simone" + ConsolePrintTool.ANSI_RESET
              + "!"
              + " Hope you are having a good day! Welcome to the BookApp starting menu. " +
              "Please choose one of the following options: ");

      printMenu();
      choice = consoleInputTool.askUserInteger("Your choice: ", 1, 9);

      switch (choice) {
        case 1:
          bookJpaDao.findAllOrderByTitle().forEach(System.out::println);
          break;
        case 2:
          bookJpaDao.findAllReadOrderedByDate().forEach(System.out::println);
          break;
        case 3:
          bookJpaDao.findAllByOrderByAuthorAndName().forEach(System.out::println);
          break;
        case 4:
          bookJpaDao.findAllArchiveOrderByTitle().forEach(System.out::println);
          break;
        case 5:

          break;
        case 6:
          UUID id = consoleInputTool.askUserUuid("Give book id: ");
          Optional<Book> bookOpt = bookJpaDao.findById(id);
          bookOpt.ifPresentOrElse(this::updateBook,
              () -> System.err.println("Unable to find book with id '" + id + "'"));

      }
    } while (choice != 7);
  }

  private void updateBook(Book book) {
    book.setDate(LocalDate.now());
    bookJpaDao.update(book);
  }

  private void addBooks(BookJpaDao bookJpaDao) {
    bookJpaDao.create(
        new Book("Tiny gaat op reis", "Koen Wauters", "97884933171", "1", Type.DETECTIVE, true,
            null));
    bookJpaDao.create(
        new Book("Koen gaat op reis", "Britney Bitch", "97884933172", "1", Type.DETECTIVE, true,
            null));
    bookJpaDao.create(
        new Book("Tom gaat op reis", "Gilbert Delahaye", "97884933173", "1", Type.ROMAN, true,
            null));
    bookJpaDao.create(
        new Book("Ward gaat op reis", "Kabouter Joren", "97884933174", "1", Type.ROMAN, false,
            null));
    bookJpaDao.create(
        new Book("Kenny gaat op reis", "Maarten Ezel Vangerven", "97884933175", "1", Type.FANTASY,
            false, null));
    bookJpaDao.create(
        new Book("Jan gaat op reis", "Tom Bombadile", "97884933176", "1", Type.FANTASY, false,
            null));
    bookJpaDao.create(
        new Book("Pelin gaat op reis", "Tiny Maarschalk", "97884933177", "1", Type.THRILLER, true,
            LocalDate.of(2020, 1, 1)));
    bookJpaDao.create(
        new Book("Memhet gaat op reis", "Pieter Smets", "97884933178", "1", Type.THRILLER, true,
            LocalDate.of(2019, 1, 1)));
    bookJpaDao.create(
        new Book("Albert gaat op reis", "Koen Vochten", "97884933179", "1", Type.THRILLER, true,
            LocalDate.of(2018, 1, 1)));
  }

  private void printMenu() {
    System.out.println("1. List all the books you want to read ordered by title.");
    System.out
        .println("2. List all the books you want to read ordered by Author and then by name.");
    System.out.println("3. List all the books you have already read ordered by date.");
    System.out.println("4. List all the books you have already read ordered by title.");
    System.out.println("5. Add a book to the list.");
    System.out.println("6. Archive a book.");
    System.out.println("7. Exit the app.");
    ConsolePrintTool.printEnter();
  }
}
