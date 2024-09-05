package academy.quarkus.pizzas;

import academy.quarkus.pizzas.model.Pizza;
import academy.quarkus.pizzas.model.Ticket;
import academy.quarkus.pizzas.model.TicketItem;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

@QuarkusTest
public class OrderPizzaTest {
    @Test
    public void testSimpleOrder(){
        // Given
        // - A pizza order with a list of items
        var muzza = Pizza.persist("Mozzarella");
        var mush = Pizza.persist("Mushrooms");
        var muzzaItem = TicketItem.persist(muzza, 1, BigDecimal.valueOf(10.00));
        var mushItem = TicketItem.persist(mush, 2, BigDecimal.valueOf(30.00));

        var items = List.of(muzzaItem, mushItem);

        var ticket = Ticket.persist(items);
        System.out.println(ticket);
        // - A customer to receive and pay
        // - A store to prepare
        // - A courier to deliver

        // When
        // - The order  is placed

        // Then
        // - Order status is "requested"
        // - Store is notified to start preparing
        // - Courier is assigned
    }
}
