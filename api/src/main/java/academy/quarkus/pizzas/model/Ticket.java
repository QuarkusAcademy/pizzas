package academy.quarkus.pizzas.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ticket extends PanacheEntity {
    LocalDateTime placedAt;
    LocalDateTime assignedAt;
    LocalDateTime deliveredAt;

    @ManyToOne
    Person customer;

    @ManyToOne
    Person courier;

    @OneToMany(
            mappedBy = "ticket",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<TicketItem> items;

    @Embedded
    Address address;

    @Transactional
    public static Ticket persist(Person customer, Person courier, Address address, List<TicketItem> items){
        var ticket = new Ticket();
        ticket.customer = customer;
        ticket.courier = courier;
        ticket.address = address;
        ticket.items = items;
        items.forEach(i -> i.ticket = ticket);
        ticket.persist();
        return ticket;
    }




    public Ticket(){
    }
}
