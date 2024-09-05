package academy.quarkus.pizzas.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@Entity
public class TicketItem extends PanacheEntity {
    @ManyToOne
    Ticket ticket;

    @ManyToOne
    Pizza pizza;

    Integer quantity;

    BigDecimal unitPrice;


    public static TicketItem persist(Pizza pizza, Integer quantity, String unitPrice){
        var item = new TicketItem();
        item.pizza = pizza;
        item.quantity = quantity;
        item.unitPrice = new BigDecimal(unitPrice);
        return item;
    }

    public TicketItem(){

    }
}
