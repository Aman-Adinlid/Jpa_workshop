package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderItemTest {

    @Test
    @DisplayName("Test1: create orderItem")
    public void test1() {
        Product product = new Product();
        OrderItem orderItem = new OrderItem();
        product.setName("Perfume");
        product.setId(2);
        product.setPrice(200);
        orderItem.setQuantity(30);
        orderItem.setProduct(product);
        orderItem.setProductOrder(orderItem.getProductOrder());
        Assertions.assertEquals("Perfume", orderItem.getProduct().getName());
    }

    @Test
    @DisplayName("Test2: calculate price")
    public void test2() {
        Product product = new Product();
        OrderItem orderItem = new OrderItem();
        product.setName("Perfume");
        product.setId(2);
        product.setPrice(200);
        orderItem.setQuantity(30);
        orderItem.setProduct(product);
        orderItem.setProductOrder(orderItem.getProductOrder());

    }


}
