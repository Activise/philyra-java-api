package io.activise.philyra.generatordraft.mongodb.user;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class UserMongoPanacheRepository implements PanacheMongoRepository<UserMongo> {
}
