package academy.quarkus.pizzas.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    String line1;
    String line2;
    String city;
    String postalCode;

    public Address(){}

    public Address(    String line1,
        String line2,
        String city,
        String postalCode
        ) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.postalCode = postalCode;
    }
}
