package io.activise.philyra.generatordraft.mongodb.user;

import javax.enterprise.context.ApplicationScoped;

import io.activise.philyra.generatordraft.user.User;
import io.activise.philyra.generatordraft.user.UserRepository;
import io.activise.philyra.paging.PagedList;
import io.activise.philyra.paging.mongodb.MongoPanachePagedList;
import io.activise.philyra.repositories.mongodb.MongoCrudRepository;

@ApplicationScoped
public class UserMongoRepository extends MongoCrudRepository<User, String> implements UserRepository {
  UserMongoRepository(UserMongoPanacheRepository delegate) {
    this.delegate = delegate;
  }

  public PagedList<User> getByName(String name) {
    return MongoPanachePagedList.of(delegate().find("name", name));
  }

}
