package academy.quarkus.pizzas.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@Entity
public class TicketItem extends PanacheEntity {
    @ManyToOne
    Pizza pizza;
    Integer quantity;
    BigDecimal unitPrice;

    @ManyToOne
    Ticket ticket;

    @Transactional
    public static TicketItem persist(Pizza pizza,
                                     Integer quantity,
                                     BigDecimal unitPrice){
        var item = new TicketItem();
        item.pizza = pizza;
        item.quantity = quantity;
        item.unitPrice = unitPrice;
        return item;
    }

    public TicketItem(){}
}
