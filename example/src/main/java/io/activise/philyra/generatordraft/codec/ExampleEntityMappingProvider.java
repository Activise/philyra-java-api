package io.activise.philyra.generatordraft.codec;

import javax.enterprise.context.ApplicationScoped;

import io.activise.philyra.generatordraft.item.InventoryItem;
import io.activise.philyra.generatordraft.mongodb.item.InventoryItemMongo;
import io.activise.philyra.mapping.EntityMappingProvider.HashMapEntityMappingProvider;

@ApplicationScoped
public class ExampleEntityMappingProvider extends HashMapEntityMappingProvider {
  public ExampleEntityMappingProvider() {
    mappingIndex.put(InventoryItem.class, InventoryItemMongo.class);
  }
}
