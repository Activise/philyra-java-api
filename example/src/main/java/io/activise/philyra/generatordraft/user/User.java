package io.activise.philyra.generatordraft.user;

import java.util.List;

import io.activise.philyra.generatordraft.item.InventoryItem;

public interface User {
  String getId();

  void setId(String id);

  String getName();

  void setName(String name);

  List<InventoryItem> getInventoryItems();

  void setInventoryItems(List<InventoryItem> inventoryItems);
}
