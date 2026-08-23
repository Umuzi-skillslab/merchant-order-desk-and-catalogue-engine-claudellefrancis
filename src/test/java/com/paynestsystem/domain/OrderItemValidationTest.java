package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderItemValidationTest {

    @Test
    void quantityMustBeGreaterThanZero() {

        Product product1 =
                new Product(1, "Monitor", 6000);

        Product product2 =
                new Product(2, "Wireless Mouse", 200);

        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(product1, 0)
        );
    }
}