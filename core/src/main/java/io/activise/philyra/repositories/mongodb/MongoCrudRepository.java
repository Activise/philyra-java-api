package io.activise.philyra.repositories.mongodb;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import io.activise.philyra.paging.PagedList;
import io.activise.philyra.paging.mongodb.MongoPanachePagedList;
import io.activise.philyra.repositories.CrudRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

@SuppressWarnings({ "all" })
public abstract class MongoCrudRepository<T, ID> implements CrudRepository<T, ID> {
  protected PanacheMongoRepositoryBase delegate;

  @Override
  public T create(T object) {
    delegate.persist(object);
    return object;
  }

  @Override
  public List<T> create(T... objects) {
    for (T object : objects) {
      delegate.persist(object);
    }
    return Arrays.asList(objects);
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
  public void delete(T... objects) {
    for (T object : objects) {
      delegate.delete(object);
    }
  }

  @Override
  public void deleteById(ID id) {
    delegate.delete("_id = ?1", id);
  }

  @Override
  public long deleteAll() {
    return delegate.deleteAll();
  }

  @Override
  public PagedList<T> findAll() {
    return MongoPanachePagedList.of(delegate.findAll());
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

  @Override
  public long count() {
    return delegate.count();
  }

  protected PanacheMongoRepositoryBase<? extends T, ID> delegate() {
    return delegate;
  }

}
