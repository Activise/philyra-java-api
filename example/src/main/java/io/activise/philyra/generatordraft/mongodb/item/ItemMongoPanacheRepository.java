package io.activise.philyra.generatordraft.mongodb.item;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

@ApplicationScoped
public class ItemMongoPanacheRepository implements PanacheMongoRepositoryBase<ItemMongo, String> {
}
