package io.activise.philyra.generatordraft.user;

import io.activise.philyra.paging.PagedList;
import io.activise.philyra.repositories.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

  public PagedList<User> getByName(String name);

}
