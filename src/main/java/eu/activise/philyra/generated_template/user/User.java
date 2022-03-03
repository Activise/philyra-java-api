package eu.activise.philyra.generated_template.user;

import java.util.List;

import eu.activise.philyra.generated_template.item.InventoryItem;

public interface User {
  String getId();

  void setId(String id);

  String getName();

  void setName(String name);

  List<InventoryItem> getInventoryItems();

  void setInventoryItems(List<InventoryItem> inventoryItems);
}
