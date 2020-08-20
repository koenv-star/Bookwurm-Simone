package be.koencorp.bookApp.dao;

import be.koencorp.bookApp.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class BookJpaDao extends AbstractJpaDao<Book, UUID> {
    public BookJpaDao(EntityManager em) {
        super(em, Book.class);
    }

    public List<Book> findAllOrderByTitle() {
        TypedQuery<Book> query = em.createQuery("SELECT e FROM Book e order by e.title", entityClass);
        return query.getResultList();
    }



}
