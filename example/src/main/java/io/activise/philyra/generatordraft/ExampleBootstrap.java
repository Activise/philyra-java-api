package io.activise.philyra.generatordraft;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Indexes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class ExampleBootstrap {
  private static final Logger LOGGER = Logger.getLogger("ListenerBean");

  @Inject
  MongoClient mongoClient;

  void onStart(@Observes StartupEvent ev) {
    LOGGER.info("The application is starting...");
    var collection = mongoClient.getDatabase("philyra-example-draft").getCollection("users");
    System.out.println(collection.countDocuments());
    collection.createIndex(Indexes.hashed("name"));
  }

  void onStop(@Observes ShutdownEvent ev) {
    LOGGER.info("The application is stopping...");
  }
}
