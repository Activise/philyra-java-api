package eu.activise.philyra.generated_template.user;

import eu.activise.philyra.paging.PagedList;
import eu.activise.philyra.repositories.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
  
  public PagedList<User> getByName(String name);

}
