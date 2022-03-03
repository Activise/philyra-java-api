package eu.activise.philyra;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.json.bind.Jsonb;

import org.junit.jupiter.api.Test;

import eu.activise.philyra.generated_template.item.InventoryItem;
import eu.activise.philyra.generated_template.item.Item;
import eu.activise.philyra.generated_template.item.ItemRepository;
import eu.activise.philyra.generated_template.mongodb.item.InventoryItemMongo;
import eu.activise.philyra.generated_template.mongodb.item.ItemMongo;
import eu.activise.philyra.generated_template.mongodb.user.UserMongo;
import eu.activise.philyra.generated_template.user.User;
import eu.activise.philyra.generated_template.user.UserRepository;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MongoInsertTest {
    @Inject
    UserRepository userRepo;

    @Inject
    ItemRepository itemRepo;

    @Inject
    Jsonb jsonb;

    @Test
    public void testInsert() {
        // var test = new ArrayList<CompletableFuture<?>>();

        // Item item = new ItemMongo();
        // item.setId("1");
        // item.setName("Erstes Item");
        
        // Item item2 = new ItemMongo();
        // item2.setId("2");
        // item2.setName("zweites Item");

        // itemRepo.create(item);
        // itemRepo.create(item2);
        // for (int i = 0; i < 500000; i++) {
        //     User user = new UserMongo();
        //     user.setId("" + i);
        //     user.setName("Steffen");

        //     InventoryItem inventoryItem = new InventoryItemMongo();
        //     inventoryItem.setCount(12);
        //     inventoryItem.setSlot(1);
        //     inventoryItem.setItem(item);

        //     InventoryItem inventoryItem2 = new InventoryItemMongo();
        //     inventoryItem2.setCount(12);
        //     inventoryItem2.setSlot(2);
        //     inventoryItem2.setItem(item2);

        //     user.getInventoryItems().add(inventoryItem);
        //     user.getInventoryItems().add(inventoryItem2);
            
        //     test.add(CompletableFuture.runAsync(() -> {
        //         userRepo.create(user);
        //     }));
        // }

        // test.forEach(CompletableFuture::join);
    }

    @Test
    public void fetchTest() {
        // var user = userRepo.findById("1");
        // user.ifPresent(u -> {
        //     u.getInventoryItems().forEach(i -> {
        //         System.out.println(i.getItem().getName());
        //     });
        // });
    }

}
