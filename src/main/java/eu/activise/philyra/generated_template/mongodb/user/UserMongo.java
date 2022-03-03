package eu.activise.philyra.generated_template.mongodb.user;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;

import eu.activise.philyra.generated_template.item.InventoryItem;
import eu.activise.philyra.generated_template.user.User;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "users")
public class UserMongo implements User {
  @BsonId
  private String id;

  private String name;

  private List<InventoryItem> inventoryItems;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public List<InventoryItem> getInventoryItems() {
    return inventoryItems != null ? inventoryItems : (inventoryItems = new ArrayList<>());
  }

  @Override
  public void setInventoryItems(List<InventoryItem> inventoryItems) {
    this.inventoryItems = inventoryItems;
  }

}
