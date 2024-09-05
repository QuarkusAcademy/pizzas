package academy.quarkus.pizzas.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Person extends PanacheEntity {
    String name;
    String phone;

    public Person(){}

}
