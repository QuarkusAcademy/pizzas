package academy.quarkus.pizzas.rs;

import academy.quarkus.pizzas.model.Pizza;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pizzas")
public class PizzaResource {
    @Transactional
    public void init(@Observes StartupEvent ev){
        var muzz = new Pizza("Mozzarella");
        muzz.persist();
        var mush = new Pizza("Mushrooms");
        mush.persist();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Pizza> hello() {
        return Pizza.listAll();
    }
}
