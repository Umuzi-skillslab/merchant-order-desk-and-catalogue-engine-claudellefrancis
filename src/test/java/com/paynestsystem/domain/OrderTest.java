package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderTest {

    private final Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");
    private final Product monitor = new Product(1, "Monitor", 6000);
    private final Product wirelessMouse = new Product(2, "Wireless Mouse", 200);

    @Test
    void calculateTotal_emptyOrder_isZero() {
        Order order = new Order(1, customer);

        assertEquals(0.0, order.calculateTotal(), 0.0001);
        assertTrue(order.getItems().isEmpty());
    }

    @Test
    void calculateTotal_singleLine() {
        Order order = new Order(1, customer);
        order.addItem(monitor, 1);

        assertEquals(6000.0, order.calculateTotal(), 0.0001);
    }

    @Test
    void calculateTotal_multipleLinesWithQuantityGreaterThanOne() {
        Order order = new Order(1, customer);
        order.addItem(monitor, 1);
        order.addItem(wirelessMouse, 2);

        assertEquals(6400.0, order.calculateTotal(), 0.0001);
        assertEquals(2, order.getItems().size());
    }

    @Test
    void calculateTotal_equalsSumOfLineSubtotals() {
        Order order = new Order(1, customer);
        order.addItem(monitor, 1);
        order.addItem(wirelessMouse, 2);

        double sumOfLines = 0.0;
        for (OrderItem item : order.getItems()) {
            sumOfLines += item.calculateTotal();
        }

        assertEquals(sumOfLines, order.calculateTotal(), 0.0001);
    }

    @Test
    void addItem_rejectsInvalidQuantity() {
        Order order = new Order(1, customer);

        assertThrows(IllegalArgumentException.class, () -> order.addItem(monitor, 0));
        assertThrows(IllegalArgumentException.class, () -> order.addItem(wirelessMouse, -5));
        assertTrue(order.getItems().isEmpty());
    }

    @Test
    void addItem_rejectsNullProduct() {
        Order order = new Order(1, customer);

        assertThrows(IllegalArgumentException.class, () -> order.addItem(null, 1));
    }

    @Test
    void getItems_returnsUnmodifiableList() {
        Order order = new Order(1, customer);
        order.addItem(monitor, 1);

        assertThrows(UnsupportedOperationException.class, () -> order.getItems().clear());
        assertThrows(UnsupportedOperationException.class,
                () -> order.getItems().add(new OrderItem(wirelessMouse, 1)));
        assertEquals(1, order.getItems().size());
        assertEquals(6000.0, order.calculateTotal(), 0.0001);
    }
}
