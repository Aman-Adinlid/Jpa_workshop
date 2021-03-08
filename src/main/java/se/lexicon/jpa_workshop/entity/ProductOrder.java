package se.lexicon.jpa_workshop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false)
    private LocalDateTime orderDateTime;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},mappedBy = "productOrder",orphanRemoval = true)
    private Collection<OrderItem> orderItems;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private AppUser customer;

    public ProductOrder() {
    }

    public void removeOrderItem(OrderItem orderItem) {
        if (orderItems != null) {
            orderItems = new ArrayList<>();
        }
        if (orderItem == null) throw new IllegalArgumentException("orderItem is null");

        orderItems.remove(orderItem);
        orderItem.setProductOrder(null);
    }

    public double calculateTotalPrice() {
        return orderItems.stream().mapToDouble(OrderItem::calculatePrice).sum();
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
