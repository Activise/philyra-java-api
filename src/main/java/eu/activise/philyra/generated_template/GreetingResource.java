package eu.activise.philyra.generated_template;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.activise.philyra.generated_template.mongodb.user.UserMongoRepository;

@Path("/hello")
public class GreetingResource {
    @Inject
    UserMongoRepository userRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@DefaultValue("1") @QueryParam("page") int page, @DefaultValue("25") @QueryParam("count") int count) {
        var result = userRepo.getByName("Steffen").getPage(page, count).asJavaList();
        result.get(0).getInventoryItems().forEach(i -> System.out.println(i.getItem().getName()));
        return Response.ok(result).build();
    }
}