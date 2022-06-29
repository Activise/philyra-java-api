package io.activise.philyra.generatordraft.mongodb.item;

import javax.enterprise.context.ApplicationScoped;

import io.activise.philyra.generatordraft.item.Item;
import io.activise.philyra.generatordraft.item.ItemRepository;
import io.activise.philyra.repositories.mongodb.MongoCrudRepository;

@ApplicationScoped
public class ItemMongoRepository extends MongoCrudRepository<Item, String> implements ItemRepository {
  ItemMongoRepository(ItemMongoPanacheRepository delegate) {
    this.delegate = delegate;
  }
}
