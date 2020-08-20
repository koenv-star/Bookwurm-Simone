//package be.koencorp.bookApp.dao;
//
//import be.koencorp.bookApp.model.Book;
//import be.koencorp.bookApp.model.Status;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//public interface BookDAO {
//
//    void setEntityManager(EntityManager entityManager);
//    Optional<Book> get(long id);
//
//    List<Book> getAll();
//
//    List<Book> getAllbyStatus(Status status);
//
//    void save(Book book);
//
//    void update(Book book, Status status);
//
//    List<Book> getBooksbyTitle(String title);
//
//    List<Book> getBooksbyWriter(String title);
//
//    Book getLast(String title, Status status);
//
//    Book getFirst(String title, Status status);
//
//}


