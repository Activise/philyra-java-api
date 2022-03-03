package eu.activise.philyra.generated_template.mongodb.user;

import javax.enterprise.context.ApplicationScoped;

import eu.activise.philyra.generated_template.user.User;
import eu.activise.philyra.generated_template.user.UserRepository;
import eu.activise.philyra.paging.PagedList;
import eu.activise.philyra.paging.mongodb.MongoPanachePagedList;
import eu.activise.philyra.repositories.mongodb.MongoCrudRepository;

@ApplicationScoped
public class UserMongoRepository extends MongoCrudRepository<User, String> implements UserRepository {
  UserMongoRepository(UserMongoPanacheRepository delegate) {
    this.delegate = delegate;
  }

  public PagedList<User> getByName(String name) {
    return MongoPanachePagedList.of(delegate().find("name", name), 4);
  }

}
