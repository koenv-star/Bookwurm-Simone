package be.koencorp.bookApp.dao;

import java.util.List;
import java.util.Optional;

/*
*hoofletter in begin elk woord
* Generieken gebruiken
 */

public interface JpaDao<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);
}
