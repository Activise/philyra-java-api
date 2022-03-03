package eu.activise.philyra.generated_template.codec;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import eu.activise.philyra.generated_template.item.InventoryItem;
import eu.activise.philyra.generated_template.mongodb.item.InventoryItemMongo;
import eu.activise.philyra.mapping.EntityMappingProvider;

@ApplicationScoped
public class ExampleEntityMappingProvider implements EntityMappingProvider {
  private Map<Class<?>, Class<?>> mappingIndex = new HashMap<>(); 

  public ExampleEntityMappingProvider() {
    mappingIndex.put(InventoryItem.class, InventoryItemMongo.class);
  }

  @Override
  public Optional<Class<?>> getTarget(Class<?> type) {
    return Optional.ofNullable(mappingIndex.get(type));
  }
  
}
