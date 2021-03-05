package se.lexicon.jpa_workshop.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false)
    private LocalDateTime orderDateTime;

    @OneToMany(mappedBy = "productOrder",orphanRemoval = true)
    private Collection<OrderItem> orderItems;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private AppUser customer;

    public ProductOrder() {
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItem.setProductOrder(null);
        orderItems.remove(orderItem);
    }

    public double calculateTotalPrice(Collection<OrderItem> orderItems) {
        return orderItems.stream().map(x -> x.calculatePrice(x.getProduct(),
                x.getQuantity())).reduce(0.0, Double::sum);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

}
