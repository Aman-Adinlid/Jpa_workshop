package se.lexicon.jpa_workshop.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class ProductOrder {
    private int id;
    private LocalDateTime orderDateTime;
    private Collection<OrderItem> orderItems;
     private AppUser appUser;


}
