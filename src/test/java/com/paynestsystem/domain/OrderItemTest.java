package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderItemTest {

    @Test
    void calculateTotal_returnsUnitPriceTimesQuantity() {
        Product wirelessMouse = new Product(2, "Wireless Mouse", 200);

        OrderItem item = new OrderItem(wirelessMouse, 2);

        assertEquals(400.0, item.calculateTotal(), 0.0001);
    }
}