package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;


@SpringBootTest
public class ProductTest {

    Product testObject;

    @BeforeEach
    public void setup() {
        testObject = new Product(1, "Food", 20);
    }

    @Test
    @DisplayName("Test 1: create Product object")
    public void test_successfully_created() {
        Assertions.assertEquals(1, testObject.getId());
        Assertions.assertEquals("Food", testObject.getName());
        Assertions.assertEquals(20, testObject.getPrice());
    }

    @Test
    @DisplayName("Test 2: test equal method")
    public void test_equals() {
        Product expected = new Product(1, "Food", 20);
        Product actual = testObject;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 3: test hashcode Product object")
    public void test_hashCode() {
        Product expected = new Product(1, "Food", 20);
        Product actual = testObject;
        Assertions.assertEquals(expected.hashCode(), actual.hashCode());

    }


}
