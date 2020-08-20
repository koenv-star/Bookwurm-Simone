package be.koencorp.bookApp.dao;

import java.util.List;
import java.util.Optional;

public interface JpaDao<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);
}
