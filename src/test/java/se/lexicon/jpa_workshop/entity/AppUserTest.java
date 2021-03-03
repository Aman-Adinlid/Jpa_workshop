package se.lexicon.jpa_workshop.entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppUserTest {

    AppUser testObject;

    @BeforeEach
    public void setup() {
        testObject = new AppUser(1, "Aman", "Adam", "aman.sar@lexicon.se");
    }

    @Test
    @DisplayName("Test 1: create AppUser object")
    public void test_successfully_created() {
        Assertions.assertEquals(1, testObject.getId());
        Assertions.assertEquals("Aman", testObject.getFirstName());
        Assertions.assertEquals("Adam", testObject.getLastName());
        Assertions.assertEquals("aman.sar@lexicon.se", testObject.getEmail());
    }

    @Test
    @DisplayName("Test 2: test equal method")
    public void test_equals() {
        AppUser expected = new AppUser(1, "Aman", "Adam", "aman.sar@lexicon.se");

        AppUser actual = testObject;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 3: test hashcode AppUser object")
    public void test_hashCode() {
        AppUser expected = new AppUser(1, "Aman", "Adam",
                "aman.sar@lexicon.se");

        AppUser actual = testObject;
        Assertions.assertEquals(expected.hashCode(), actual.hashCode());

    }

}
