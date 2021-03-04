package se.lexicon.jpa_workshop.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class ProductOrder {
    private int id;
    private LocalDateTime orderDateTime;
    @OneToMany(mappedBy = "productOrder")
    private Collection<OrderItem> orderItems;
    private AppUser customer;

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
