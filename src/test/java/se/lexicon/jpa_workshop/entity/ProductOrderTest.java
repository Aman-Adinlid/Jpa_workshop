package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
public class ProductOrderTest {

    ProductOrder productOrder;
    Collection<OrderItem> orderItems;

    @Test
    @DisplayName("Test1: create productOrder")
    public void test1() {
        ProductOrder productOrder = new ProductOrder();
        Collection<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        productOrder.setOrderItems(orderItems);
        productOrder.setOrderDateTime(LocalDateTime.now());
        productOrder.setCustomer(productOrder.getCustomer());
        orderItem.setQuantity(20);
        orderItem.setId(3);
        orderItem.setProduct(orderItem.getProduct());
        Assertions.assertEquals(orderItems, productOrder.getOrderItems());

    }


}
