package io.activise.philyra.generatordraft.item;

public interface InventoryItem {
  String getItemId();

  void setItemId(String itemId);

  Item getItem();

  void setItem(Item item);

  int getAmount();

  void setAmount(int amount);

  int getSlot();

  void setSlot(int slot);
}
