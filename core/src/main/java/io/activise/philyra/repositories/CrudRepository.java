package io.activise.philyra.repositories;

import java.util.List;
import java.util.Optional;

import io.activise.philyra.paging.PagedList;

public interface CrudRepository<T, ID> {

  T create(T object);

  List<T> create(T... objects);

  T createOrUpdate(T object);

  PagedList<T> findAll();

  Optional<T> findById(ID id);

  T update(T object);

  void delete(T object);

  void delete(T... objects);

  void deleteById(ID id);

  long deleteAll();

  long count();

}
