package be.koencorp.bookApp.dao;

import be.koencorp.bookApp.model.Book;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class BookJpaDao extends AbstractJpaDao<Book, UUID> {
    public BookJpaDao(EntityManager em) {
        super(em, Book.class);
    }

    public List<Book> findAllOrderByTitle() {
        TypedQuery<Book> query = em.createQuery("SELECT e FROM Book e WHERE e.date IS NULL ORDER BY e.title", entityClass);
        return query.getResultList();
    }

    public List<Book> findAllByOrderByAuthorAndName() {
        TypedQuery<Book> query = em.createQuery("SELECT e FROM Book e  WHERE e.date IS NULL ORDER BY e.author,e.title", entityClass);
        return query.getResultList();
    }

    public List<Book> findAllReadOrderedByDate() {
        TypedQuery<Book> query = em.createQuery("SELECT e FROM Book e WHERE e.date is not null order by e.date", entityClass);
        return query.getResultList();
    }

    public List<Book> findAllArchiveOrderByTitle() {
        TypedQuery<Book> query = em.createQuery("SELECT e FROM Book e WHERE e.date IS NOT NULL ORDER BY e.title", entityClass);
        return query.getResultList();
    }
}
