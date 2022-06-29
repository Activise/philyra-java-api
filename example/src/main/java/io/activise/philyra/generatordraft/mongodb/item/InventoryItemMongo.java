package io.activise.philyra.generatordraft.mongodb.item;

import javax.enterprise.inject.spi.CDI;
import javax.json.bind.annotation.JsonbTransient;

import org.bson.codecs.pojo.annotations.BsonIgnore;

import io.activise.philyra.generatordraft.item.InventoryItem;
import io.activise.philyra.generatordraft.item.Item;
import io.activise.philyra.generatordraft.item.ItemRepository;

public class InventoryItemMongo implements InventoryItem {
  private static transient ItemRepository itemRepository;

  private int amount;
  private int slot;

  private String itemId;

  @JsonbTransient
  @BsonIgnore
  @Override
  public Item getItem() {
    return getItemRepository().findById(itemId).get();
  }

  @Override
  public String getItemId() {
    return itemId;
  }

  @Override
  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  @Override
  public void setItem(Item item) {
    itemId = item.getId();
  }

  @Override
  public int getAmount() {
    return amount;
  }

  @Override
  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public int getSlot() {
    return slot;
  }

  @Override
  public void setSlot(int slot) {
    this.slot = slot;
  }

  private static ItemRepository getItemRepository() {
    return itemRepository != null ? itemRepository
        : (itemRepository = CDI.current().select(ItemRepository.class).get());
  }
}
