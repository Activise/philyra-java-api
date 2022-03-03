package eu.activise.philyra.repositories;

import java.util.Optional;

public interface CrudRepository<T, ID> {
    
    T create(T object);

    T createOrUpdate(T object);

    Optional<T> findById(ID id);

    T update(T object);

    void delete(T object);

    void deleteById(ID id);

}
