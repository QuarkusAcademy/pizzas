package academy.quarkus.pizzas.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

@Entity
public class Person extends PanacheEntity {
    String name;
    String phone;

    @Transactional
    public static Person persist(String name, String phone) {
        var person = new Person();
        person.name = name;
        person.phone = phone;
        person.persist();
        return person;
    }

    public Person() {

    }
}
