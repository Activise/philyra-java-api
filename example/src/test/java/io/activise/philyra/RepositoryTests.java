package io.activise.philyra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.activise.philyra.generatordraft.item.InventoryItem;
import io.activise.philyra.generatordraft.item.Item;
import io.activise.philyra.generatordraft.item.ItemRepository;
import io.activise.philyra.generatordraft.mongodb.item.InventoryItemMongo;
import io.activise.philyra.generatordraft.mongodb.item.ItemMongo;
import io.activise.philyra.generatordraft.mongodb.user.UserMongo;
import io.activise.philyra.generatordraft.user.User;
import io.activise.philyra.generatordraft.user.UserRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongodb.MongoTestResource;

@QuarkusTest
@QuarkusTestResource(MongoTestResource.class)
public class RepositoryTests {
  @Inject
  UserRepository userRepo;

  @Inject
  ItemRepository itemRepo;

  @BeforeEach
  public void setup() {
    userRepo.deleteAll();
    itemRepo.deleteAll();
  }

  @Test
  public void create_SingleEntity_Success() {
    assertEquals(0, itemRepo.count());

    Item item1 = createItem("1", "Erstes Item");
    Item item2 = createItem("2", "Zweites Item");
    itemRepo.create(item1, item2);

    assertEquals(2, itemRepo.count());

    Optional<Item> foundItem1 = itemRepo.findById("1");
    assertEquals("Erstes Item", foundItem1.get().getName());

    Optional<Item> foundItem2 = itemRepo.findById("2");
    assertEquals("Zweites Item", foundItem2.get().getName());
  }

  @Test
  public void create_EmbeddedAndRelation_Success() {
    assertEquals(0, userRepo.count());

    Item item1 = createItem("1", "Erstes Item");
    Item item2 = createItem("2", "Zweites Item");
    itemRepo.create(item1, item2);

    User user = createUser("1", "Max Mustermann");
    user.getInventoryItems().add(createInventoryItem(10, 1, item1));
    user.getInventoryItems().add(createInventoryItem(20, 2, item2));

    userRepo.create(user);

    Optional<User> foundUser = userRepo.findById("1");
    assertEquals(2, foundUser.get().getInventoryItems().size());

    InventoryItem foundInventoryItem1 = foundUser.get().getInventoryItems().get(0);
    Item foundItem1 = foundInventoryItem1.getItem();
    assertEquals("Erstes Item", foundItem1.getName());
    assertEquals(10, foundInventoryItem1.getAmount());
    assertEquals(1, foundInventoryItem1.getSlot());

    InventoryItem foundInventoryItem2 = foundUser.get().getInventoryItems().get(1);
    Item foundItem2 = foundInventoryItem2.getItem();
    assertEquals("Zweites Item", foundItem2.getName());
    assertEquals(20, foundInventoryItem2.getAmount());
    assertEquals(2, foundInventoryItem2.getSlot());
  }

  private User createUser(String id, String name) {
    User user = new UserMongo();
    user.setId(id);
    user.setName(name);
    return user;
  }

  private Item createItem(String id, String name) {
    Item item = new ItemMongo();
    item.setId(id);
    item.setName(name);
    return item;
  }

  private InventoryItem createInventoryItem(int amount, int slot, Item item) {
    InventoryItem inventoryItem = new InventoryItemMongo();
    inventoryItem.setAmount(amount);
    inventoryItem.setSlot(slot);
    inventoryItem.setItem(item);
    return inventoryItem;
  }
}
