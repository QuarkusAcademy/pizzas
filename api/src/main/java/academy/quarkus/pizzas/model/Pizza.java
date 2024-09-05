package academy.quarkus.pizzas.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

@Entity
public class Pizza extends PanacheEntity {
    String description;

    @Transactional
    public static Pizza persist(String description){
        var pizza = new Pizza();
        pizza.description = description;
        pizza.persist();
        return pizza;
    }

    public Pizza(){}

    public Pizza(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
