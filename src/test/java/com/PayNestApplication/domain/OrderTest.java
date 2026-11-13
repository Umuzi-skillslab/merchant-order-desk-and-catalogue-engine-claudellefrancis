package com.PayNestApplication.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test

    void calculateTotalReturnsGrandTotal() {

        Customer customer =
                new Customer(1, "Claudelle", "claudelle.francis@umuzi.org");

        Order order =
                new Order(1, customer);

        Product monitor =
                new Product(1, "Monitor", 5000);

        Product iPad =
                new Product(2, "iPad", 15000);

        Product keyboard =
                new Product(3, "Keyboard", 500);

        order.addItem(monitor, 1);
        order.addItem(iPad, 1);
        order.addItem(keyboard, 1);

        assertEquals(20500, order.calculateTotal());

    }

}