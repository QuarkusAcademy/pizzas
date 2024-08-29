package academy.quarkus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Pizza extends PanacheEntity {
    String description;

    public Pizza(){}

    public Pizza(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
