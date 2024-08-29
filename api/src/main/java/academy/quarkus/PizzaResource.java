package academy.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pizzas")
public class PizzaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        var muzz = new Pizza("Mozzarella");
        var mush = new Pizza("Mushrooms");
        var pizzas = List.of(muzz, mush);
        return pizzas;
    }
}
