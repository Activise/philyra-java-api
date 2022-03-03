package eu.activise.philyra.generated_template.mongodb.item;

import javax.enterprise.context.ApplicationScoped;

import eu.activise.philyra.generated_template.item.Item;
import eu.activise.philyra.generated_template.item.ItemRepository;
import eu.activise.philyra.repositories.mongodb.MongoCrudRepository;

@ApplicationScoped
public class ItemMongoRepository extends MongoCrudRepository<Item, String> implements ItemRepository {
    ItemMongoRepository(ItemMongoPanacheRepository delegate) {
        this.delegate = delegate;
    }
}
