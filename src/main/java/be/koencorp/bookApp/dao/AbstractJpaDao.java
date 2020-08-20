package be.koencorp.bookApp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class AbstractJpaDao<T, ID> implements JpaDao<T, ID> {

    protected final EntityManager em;
    protected final Class<T> entityClass;

    protected AbstractJpaDao(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }


    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(em.find(entityClass, id));
    }

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = em.createQuery("FROM" + entityClass.getName(), entityClass);
        return query.getResultList();

    }

    @Override
    public void create(T entity) {
        executeInsideTransaction(entityManager -> entityManager.persist(entity));
    }

    @Override
    public void update(T entity) {
        executeInsideTransaction(entityManager -> entityManager.merge(entity));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
