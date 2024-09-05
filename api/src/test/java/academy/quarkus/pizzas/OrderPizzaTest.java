package academy.quarkus.pizzas;

import academy.quarkus.pizzas.model.*;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class OrderPizzaTest {
    @Test
    public void testSimplePizzaOrder(){
        // Given
        // - a pizza order
        // -- with a list o items
        // -- for a given customer
        // -- by a given courier
        var customer = Person.persist("Alice", "+55111111");
        var courier = Person.persist("Bob", "+55222222");
        var marga = Pizza.persist("Marguerita");
        var veggies = Pizza.persist("Vegetables");
        var iMarga = TicketItem.persist(marga, 1, "10.00");
        var iVeggies = TicketItem.persist(veggies, 2, "15.00");
        var items = List.of(iMarga, iVeggies);
        var addr = new Address("Fool's St. 0", "Apto 000", "Nocity", "000000");
        var ticket = Ticket.persist(customer, courier,addr, items);
        Assertions.assertNotNull(ticket);
        // When
        // -- The order is placed

        // Then
        // -- The order status is requested
        // -- The store is notified
        // -- The rider is assigned
    }
}
