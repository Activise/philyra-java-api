package eu.activise.philyra.generated_template.mongodb.item;

import javax.enterprise.inject.spi.CDI;
import javax.json.bind.annotation.JsonbTransient;

import org.bson.codecs.pojo.annotations.BsonIgnore;

import eu.activise.philyra.generated_template.item.InventoryItem;
import eu.activise.philyra.generated_template.item.Item;
import eu.activise.philyra.generated_template.item.ItemRepository;

public class InventoryItemMongo implements InventoryItem {
    private transient ItemRepository itemRepository;
    
    private int count;
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
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public void setSlot(int slot) {
        this.slot = slot;
    }

    private ItemRepository getItemRepository() {
      return itemRepository != null ? itemRepository : (itemRepository = CDI.current().select(ItemRepository.class).get());
    }
}
