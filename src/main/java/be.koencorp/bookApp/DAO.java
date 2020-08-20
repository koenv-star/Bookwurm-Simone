package be.koencorp.bookApp;

import javax.persistence.*;
import java.util.*;
import java.util.function.Consumer;

public class DAO implements BookDAO {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Book> get(long id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    public List<Book> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Book e");
        return query.getResultList();
    }

    @Override
    public List<Book> getAllbyStatus(Status status) {
        Query query = entityManager.createQuery("SELECT e FROM Book e WHERE e.status=?1");
        query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    public void save(Book book) {
        executeInsideTransaction(entityManager -> entityManager.persist(book));
    }

    @Override
    public void update(Book book, Status status) {
        book.setStatus(Objects.requireNonNull(status, "Status cannot be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(book));
    }

    @Override
    public List<Book> getBooksbyTitle(String title) {
        Query query = entityManager.createQuery("SELECT e FROM Book e WHERE e.title=?1");
        query.setParameter(1, title);
        return query.getResultList();
    }

    @Override
    public List<Book> getBooksbyWriter(String writer) {
        Query query = entityManager.createQuery("SELECT e FROM Book e WHERE e.writer =?1");
        query.setParameter(1, writer);
        return query.getResultList();
    }

    @Override
    public Book getLast(String title, Status status) {
        Query query = entityManager.createQuery("SELECT e FROM Book e WHERE e.title =?1 and e.status=?2 ORDER BY e.id");
        query.setParameter(1, title);
        query.setParameter(2, status);
        List<Book> books = query.getResultList();
        return books.get(books.size() - 1);
    }

    @Override
    public Book getFirst(String title, Status status) {
        Query query = entityManager.createQuery("SELECT e FROM Book e WHERE e.title =?1 and e.status=?2 ORDER BY e.id");
        query.setParameter(1, title);
        query.setParameter(2, status);
        List<Book> books = query.getResultList();
        return books.get(0);
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
