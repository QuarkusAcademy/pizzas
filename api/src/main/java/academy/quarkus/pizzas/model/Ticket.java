package academy.quarkus.pizzas.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

@Entity
public class Ticket extends PanacheEntity {
    @ManyToOne
    Person customer;

    @ManyToOne
    Person courier;

    @Embedded
    Address address;

    @OneToMany(
            mappedBy = "ticket",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<TicketItem> items;

    @Transactional
    public static Ticket persist(List<TicketItem> items){
        var ticket = new Ticket();
        ticket.items = items;
        items.forEach(i -> i.ticket = ticket);
        ticket.persist();
        return ticket;
    }

    public Ticket(){}

}
