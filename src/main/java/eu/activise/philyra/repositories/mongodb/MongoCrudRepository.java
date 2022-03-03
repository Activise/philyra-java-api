package eu.activise.philyra.repositories.mongodb;

import java.util.Optional;

import eu.activise.philyra.repositories.CrudRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@SuppressWarnings({ "all" })
public abstract class MongoCrudRepository<T, ID> implements CrudRepository<T, ID>  {
    protected PanacheMongoRepository delegate;

    @Override
    public T create(T object) {
        delegate.persist(object);
        return object;
    }

    @Override
    public T createOrUpdate(T object) {
        delegate.persistOrUpdate(object);
        return object;
    }

    @Override
    public void delete(T object) {
        delegate.delete(object);
    }

    @Override
    public void deleteById(ID id) {
        delegate.delete("_id = ?1", id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return delegate.find("_id = ?1", id).firstResultOptional();
    }

    @Override
    public T update(T object) {
        delegate.update(object);
        return object;
    }

    protected PanacheMongoRepository<? extends T> delegate() {
        return delegate;
    }

}
