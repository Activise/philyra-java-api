package io.activise.philyra.generatordraft.mongodb.item;

import org.bson.codecs.pojo.annotations.BsonId;

import io.activise.philyra.generatordraft.item.Item;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "items")
public class ItemMongo implements Item {
  @BsonId
  private String id;

  private String name;

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
}
