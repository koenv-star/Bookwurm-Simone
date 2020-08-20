package be.koencorp.bookApp;

import java.util.List;
import java.util.Optional;

public interface BookDAO {

    Optional<Book> get(long id);

    List<Book> getAll();

    List<Book> getAllbyStatus(Status status);

    void save(Book book);

    void update(Book book, Status status);

    List<Book> getBooksbyTitle(String title);

    List<Book> getBooksbyWriter(String title);

    Book getLast(String title, Status status);

    Book getFirst(String title, Status status);

}
